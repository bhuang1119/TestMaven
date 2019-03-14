package com.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class NIOServer {

    private int flag = 0;
    private int BLOCK = 4096;
    private ByteBuffer sendBuffer = ByteBuffer.allocate(BLOCK);
    private ByteBuffer receiveBuffer = ByteBuffer.allocate(BLOCK);

    private Selector selector;

    public NIOServer(int port) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(port));
        selector = Selector.open();
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        System.out.println("Server Start"+port);
    }

    private void listen() throws IOException {
        while (true){
            selector.select();
            System.out.println("listen");
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                handleKey(selectionKey);
            }
        }
    }

    private void handleKey(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel clientSocketChannel = null;
        String receiveText;
        String sendText;
        int count = 0;
        if(selectionKey.isAcceptable()){
            serverSocketChannel =(ServerSocketChannel) selectionKey.channel();
            clientSocketChannel = serverSocketChannel.accept();
            clientSocketChannel.configureBlocking(false);
            clientSocketChannel.register(selector,SelectionKey.OP_READ);
            System.out.println("接收连接：");

        }else if(selectionKey.isReadable()){
            clientSocketChannel =(SocketChannel) selectionKey.channel();
            receiveBuffer.clear();
            count = clientSocketChannel.read(receiveBuffer);
            if(count>0){
                receiveText = new String(receiveBuffer.array(),0,count);
                System.out.println("服务端接收客户端数据："+receiveText);
                clientSocketChannel.register(selector,SelectionKey.OP_WRITE);
            }
        }else if(selectionKey.isWritable()){
            sendBuffer.clear();
            clientSocketChannel=(SocketChannel)selectionKey.channel();
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 8888;
        NIOServer server = new NIOServer(port);
        server.listen();
    }

}
