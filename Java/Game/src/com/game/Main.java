package com.game;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String temp = "";
        char[] beg;
        int j = 999;
        ArrayList<String> array = new ArrayList<String>();
        for(int i = 330; i < j; i++) {
            for (; j > i; j--) {
                temp = new Integer(i * j).toString();
                System.out.println(temp);
                beg = temp.substring(0,3).toCharArray();
                if (temp.substring(3, 6).equals(beg[2]+ "" +beg[1] + "" + beg[0])) {
                    array.add(temp);
                }
            }
            j = 999;
        }

        Collections.sort(array);
        for(String a : array) {
            System.out.println(a);

        }
    }
}
