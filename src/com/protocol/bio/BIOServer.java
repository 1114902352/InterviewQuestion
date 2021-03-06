package com.protocol.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    //
    public static void main(String[] args) throws IOException {
        // step1: new ServerSocket(8090)
        ServerSocket server = new ServerSocket(8090);
        while(true){
            // step2: server.accept()
            Socket client = server.accept();// 此处会阻塞
            new Thread(new Runnable() {
                Socket socket;
                public Runnable setSocket(Socket socket) {
                    this.socket = socket;
                    return this;
                }
                @Override
                public void run() {
                    try {
                        InputStream in = socket.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        String resp;
                        while((resp = reader.readLine()) != null){// 此处会阻塞
                            System.out.println(resp);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.setSocket(client)).start();
        }
    }
}
