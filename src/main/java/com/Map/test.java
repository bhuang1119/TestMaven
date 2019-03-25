package com.Map;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @Author: huangbin
 * @Description:
 * @Date: Created in 
 * @Modified By:
 */
public class test {

    public static void main(String[] args) {
//        int length = 16;
//        TreeMap map = new TreeMap<String,String>();
//        for(int i=0;i<length;i++){
//            System.out.println(i);
//            map.put(i+"","value"+i);
//        }

        HashMap map = new HashMap(2);

        map.put("1","value1");

        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put("2","value2");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                map.put("3","value3");
            }
        }).start();
    }
}
