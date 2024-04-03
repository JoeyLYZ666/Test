package org.example;

import org.example.backpack.BackpackUltimate;
import org.example.backpack.Backpack;
import org.example.backpack.BackpackImpl;
import org.example.bubble.BubbleSort;
import org.example.bubble.BubbleSortImpl;
import org.example.bubble.BubbleSortUltimate;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        // BubbelSort
        BubbleSort bubbleSort = new BubbleSortImpl();
        List<Integer> list = Arrays.asList(0);
        bubbleSort.bubbleSort(list);
        System.out.println(list);

        // Backpack
        Backpack backpack = new BackpackImpl();
        List<Integer> weights = Arrays.asList(5, 4, 7, 2, 3);
        List<Integer> values = Arrays.asList(3, 4, 5, 8, 6);
        int capacity = 10;
        System.out.println(backpack.backpack(weights, values, capacity));

        // 最终版
        BubbleSortUltimate bubbleSortUltimate = new BubbleSortUltimate();
        List<Integer> list1 = Arrays.asList(2, 10, 4, 5);
        List<Integer> result = bubbleSortUltimate.bubbleSort(list1);
        System.out.println(result);

        // 最终版
        BackpackUltimate backPackUltimate = new BackpackUltimate();
        System.out.println(backPackUltimate.backpack(weights, values, capacity));
    }
}