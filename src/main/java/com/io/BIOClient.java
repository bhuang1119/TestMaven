package com.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class BIOClient implements Runnable {

    public static void main(String[] args) throws IOException {
        new Thread(new BIOClient()).start();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see     Thread#run()
     */
    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            OutputStream outputStream = socket.getOutputStream();

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入：");
            String mess = scanner.nextLine();
            outputStream.write(mess.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
