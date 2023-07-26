/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Andre Sebastián
 */
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Servidor extends Thread {

    private final JTextArea areatexto;

    public final static int PUERTO_SERVIDOR = 5000;

    public Servidor(JTextArea areatexto) {
        this.areatexto = areatexto;

    }

    @Override
    public void run() {

        try {

            //Creamos la instancia del socket servidor
            ServerSocket serverSocket = new ServerSocket(PUERTO_SERVIDOR);

            while (true) {
                try ( Socket socket = serverSocket.accept()) {
                    DataInputStream FlujoEntrada = new DataInputStream(socket.getInputStream());

                    String mensaje = FlujoEntrada.readUTF();
                    areatexto.append(mensaje);
                }
            }
        } catch (IOException ex) {

            System.out.println("Mensaje de eeror" + ex.getMessage());

        }
    }
}
