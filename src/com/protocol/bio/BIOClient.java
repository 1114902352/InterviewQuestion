package com.protocol.bio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class BIOClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream out = null;
        BufferedWriter writer = null;
        try {
            socket = new Socket("127.0.0.1", 8090);
            out = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write("Hello World!");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
