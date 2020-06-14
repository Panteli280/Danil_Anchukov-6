package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("Pairs.txt");
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes);
        fis.close();
        String[] valueStr = new String(bytes).trim().split("\\s+");
        int[] accArray = new int[valueStr.length];
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите сумму: ");
        int sum = scn.nextInt();

        ArrayList list = task.task(accArray, sum);
        System.out.println(list);
        //
        ArrayList list2 = java.javaTask(accArray, sum);
        System.out.println(list2);
    }
}