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
        int length = 16;
        TreeMap map = new TreeMap<String,String>();
        for(int i=0;i<length;i++){
            System.out.println(i);
            map.put(i+"","value"+i);
        }

    }
}
