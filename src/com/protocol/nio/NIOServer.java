package com.protocol.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

public class NIOServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        LinkedList<SocketChannel> clients = new LinkedList<>();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(8091));
        server.configureBlocking(false); // NONBlocking
//        server.setOption(StandardSocketOptions.TCP_NODELAY,false);
        while(true){
            Thread.sleep(1000);
            // --------------- step1 接收客户端
            SocketChannel client = server.accept();// 不会阻塞
            // 没有客户端连接，返回null
            if(client == null){
                System.out.println("There is no client connection");
            }else{
                // 配置非阻塞客户端，
                client.configureBlocking(false);
                System.out.println("Connected client port:"+client.socket().getPort());
                clients.add(client);// 放入链表
            }

            // ---------------- step2 读取客户端数据
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096); // 分配对外内存
            for (SocketChannel socket : clients) {
                // 从客户端读取数据，不会阻塞，返回值为>0 -1 0
                int num = socket.read(buffer);// 从socket中读取数据放入到buffer中
                // >0 读取到数据
                if(num > 0){
                    // "写出模式"，重设指针，确保能够读到有效数据，即position和limit之间的数据
                    // limit=position,position=0,capacity不变
                    buffer.flip();
                    // 定义一个有效数据长度的新数组
                    byte[] array = new byte[buffer.limit()];
                    // 读取有效数据放入到新数组中
                    buffer.get(array);
                    String resp = new String(array);
                    System.out.println(socket.socket().getPort()+":"+resp);
                    buffer.clear();
                }
            }
        }
    }
}
