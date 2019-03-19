/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author duche
 */
public class ReceptorUDP {

    public static void main(String[] args) {
        try {
            DatagramSocket receptor = new DatagramSocket(1500); //Puerto de escucha
            byte[] cadena = new byte[1000]; //Tamaño máximo del paquete (interpreto que este dato se debería comunicar por tcp entre el cliente y el servidor)
            DatagramPacket paquete = new DatagramPacket(cadena, cadena.length);
            System.out.println("A la espera de paquetes...");
            while (true){
                receptor.receive(paquete);
                System.out.println(new String(paquete.getData(),0,paquete.getLength()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
