/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.distribuidos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class ChatThread extends Thread {
    
    private Socket socket;
    private final static List<ChatThread> clientes = new ArrayList<ChatThread>();
    private DataInputStream in;
    private DataOutputStream out;
    
     public ChatThread(Socket cliente) {
        try {
            this.socket = cliente;
            clientes.add(this);

            in = new DataInputStream(new BufferedInputStream(cliente.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(cliente.getOutputStream()));

            enviarMensagem("Cliente " + socket.getInetAddress().getHostAddress() + " entrou no chat.");
            synchronized(out) {
                out.writeUTF("Bem vindo ao chat " + socket.getInetAddress().getHostAddress() + "\n");
            }
            out.flush();
        } catch (IOException ex) {
            ex.getMessage();
        }
}
     
    public void run() {
        try {
            try {
                boolean sair = false;
                while(!sair) {
                    String texto = in.readUTF();
                    if("SAIR".equals(texto)) {
                        sair = true;
                        clientes.remove(this);
                        enviarMensagem("Cliente " + socket.getInetAddress().getHostAddress() + " saiu do chat.");
                    } else {
                        enviarMensagem(texto);
                    }
                }
            } finally {
                if(!this.socket.isClosed()) {
                    this.socket.close();
                }
            }
        } catch (IOException ex) {
            ex.getMessage();
            System.out.println("Não conseguiu comunicar com o cliente.");
        }
}
    
    private void enviarMensagem(String mensagem) {
        System.out.println("Enviar msg: " + mensagem);
        synchronized(clientes) {
            for(ChatThread cliente : clientes) {
                try {
                    synchronized(cliente.out) {
                        cliente.out.writeUTF(mensagem + "\n");
                    }
                    cliente.out.flush();
                } catch (IOException ex) {
                    ex.getMessage();
                    cliente.interrupt();
                }
            }
        }
}
}
