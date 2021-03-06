package com.protocol.netty_book.aio;

import com.protocol.netty_book.nio.MultiplexerTimeServer;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        AsynTimeServerHandler server = new AsynTimeServerHandler(port);
        new Thread(server,"AIO-AsyncTimeServerHandler-001").start();
    }
}
