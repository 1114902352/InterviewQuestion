package com.protocol.netty_book.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port :" + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new Runnable() {

                    private Socket socket;

                    @Override
                    public void run() {
                        BufferedReader in = null;
                        PrintWriter out = null;
                        try {
                            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                            out = new PrintWriter(this.socket.getOutputStream(), true);
                            String currentTime = null;
                            String body = null;
                            while (true) {
                                body = in.readLine();
                                if (body == null) {
                                    break;
                                }
                                System.out.println("The time server receive order:" + body);
                                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                                out.println(currentTime);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (in != null) {
                                try {
                                    in.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (out != null) {
                                out.close();
                            }
                            if (this.socket != null) {
                                try {
                                    this.socket.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            this.socket = null;
                        }
                    }

                    public Runnable setSocket(Socket socket) {
                        this.socket = socket;
                        return this;
                    }
                }.setSocket(socket)).start();
            }
        } finally {
            if (server != null) {
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
