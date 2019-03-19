/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author duche
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ServerSocket servidor = new ServerSocket(2500);
            System.out.println("Esperando nuevos clientes...");
            Socket cliente = servidor.accept();
            System.out.println("Cliente Aceptado");
            DataInputStream flujo_entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(cliente.getOutputStream());
            flujo_salida.writeUTF("Conectado");
            System.out.println("Mensaje cliente: " + flujo_entrada.readUTF());
            cliente.close();
            servidor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
