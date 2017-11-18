/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.distribuidos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author vinicius caetano
 */
public class ChatServer  {
    
    
    public static void main(String[] args) throws Exception{
      ServerSocket server = new ServerSocket(9876);
        System.out.println("Server inicializado.");
        
        try {
            while(true) {
                Socket socket = server.accept();
                Runnable r = new ChatThread(socket);
                Thread t = new Thread(r);
                t.start();
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
            System.out.println("Não encontrou o host servidor.");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Não conseguiu abrir conexão com o host.");
        } finally {
            try {
                if(!server.isClosed()) {
                    server.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Erro ao fechar a conexão do socket servidor.");
            }
        }
    }
}
    

