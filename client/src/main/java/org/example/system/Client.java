package org.example.system;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    private SocketChannel socketChannel;
    private final Gson gson = new Gson();

    public void connect(String host, int port) throws IOException {
        socketChannel = SocketChannel.open(new InetSocketAddress(host, port));
    }

    public String sendRequest(String request) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(request.getBytes());
        socketChannel.write(buffer);

        ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(responseBuffer);
        return new String(responseBuffer.array()).trim();
    }
}