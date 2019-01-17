package com.testTransient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in
 * @Modified By:
 */
public class TransientTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("huangbin");
        user.setPasswd("123456");
        System.out.println("read before Serializable:");
        System.out.println("username:"+user.getUsername());
        System.out.println("password:"+user.getPasswd());
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("./user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            user.setUsername("huying");

            ObjectInputStream is = new ObjectInputStream((new FileInputStream("./user.txt")));
            user = (User)is.readObject();
            is.close();
            System.out.println("\nread after Serializable:");
            System.out.println("username:"+user.getUsername());
            System.out.println("password:"+user.getPasswd());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
