package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class java {

    public static ArrayList javaTask (int[] input, int sum) {
        ArrayList list = new ArrayList<>();
        HashMap pairs = new HashMap();
        for (int i : input) {
            if (pairs.containsKey(i)) {
                if (pairs.get(i) != null) {
                    addPairs(list, i, sum - i);
                }
                pairs.put(sum - i, null);
            } else if (!pairs.containsValue(i)) {
                pairs.put(sum - i, i);
            }
        }
        return list;
    }

    private static void addPairs(ArrayList list, int i, int j) {
        String pair = i + " and " + j;
        list.add(pair);
    }
}