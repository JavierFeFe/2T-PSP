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
public class ServidorMulti extends Thread {

    private Socket cliente;

    public ServidorMulti(Socket client) {
        this.cliente = client;
    }

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2500);
            System.out.println("Esperando nuevos clientes...");
            while (true) {
                new ServidorMulti(server.accept()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente Aceptado");
            DataInputStream flujo_entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(cliente.getOutputStream());
            flujo_salida.writeUTF("Conectado");
            System.out.println("Mensaje cliente: " + flujo_entrada.readUTF());
            cliente.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
