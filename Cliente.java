/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author duche
 */
public class Cliente {
    
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("127.0.0.1", 2500);
            DataInputStream flujo_entrada = new DataInputStream(cliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(cliente.getOutputStream());
            System.out.println("Esperando Conexión...");
            String conexion = flujo_entrada.readUTF();
            if (conexion.equals("Conectado")) {
                System.out.println("Conectado al servidor...");
                flujo_salida.writeUTF("Hola Servidor");
            }
            cliente.close();
        } catch (Exception e) {
            
        }
    }
    
}
