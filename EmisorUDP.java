/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author duche
 */
public class EmisorUDP {
    
    public static void main (String[] args){
        try{
            String texto="Esto es un mensaje de prueba UDP";
            DatagramSocket emisor = new DatagramSocket();
            byte[] cadena = texto.getBytes(); //Convierto el texto a bytes (podría capturar estos datos de un fichero)
            DatagramPacket paquete = new DatagramPacket(cadena, cadena.length, InetAddress.getByName("127.0.0.1"),1500);
            System.out.println("Enviando paquete...");
            emisor.send(paquete);
            //Ejemplo de envio de fichero
            FileInputStream archivo = new FileInputStream("prueba.txt");
            BufferedInputStream archivo_buff = new BufferedInputStream(archivo);
            byte[] cadena2 = new byte[20];
            while(archivo_buff.read(cadena2) != -1){
                paquete = new DatagramPacket(cadena2,cadena2.length, InetAddress.getByName("127.0.0.1"),1500);
                emisor.send(paquete);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
