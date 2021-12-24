package io.renren.test;

import java.util.ArrayList;

public class Demo03 {
    // m
    byte[] array = new byte[1024 * 1024];

    public static void main(String[] args) {
        ArrayList<Demo03> list = new ArrayList<>();
        int count = 0;
        //oom 一般都是死循环

        while (true) {
            list.add(new Demo03());
            count++;
        }
    }
}
