package org.example.bubble;

import org.junit.*;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

public class BubbleSortUltimateTest{
    public BubbleSortUltimate bubbleSortUltimate;


    @Before
    public void prepare() {
        bubbleSortUltimate = new BubbleSortUltimate();
        System.out.println("-------------------------");
    }

    @Test
    public void bubbleSortTest() {
        // 普通测试
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(1, 2, 3, 4, 5)), Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(2, 10, 4, 5)), Arrays.asList(2, 4, 5, 10));
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(-1, 4, 7, 2)), Arrays.asList(-1, 2, 4, 7));
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(5, 3, 8, 2, 1)), Arrays.asList(1, 2, 3, 5, 8));
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(5, 4, 3, 2, 1)), Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(6, 3, 15, 8, 12)), Arrays.asList(3, 6, 8, 12, 15));
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(10, 2, 33, 9, 100)), Arrays.asList(2, 9, 10, 33, 100));
        // 特殊情况
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList()), Arrays.asList());// 空处理
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(5)), Arrays.asList(5));// 单个元素处理
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(2, 3, 4, -1)), Arrays.asList(-1, 2, 3, 4));
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(10, 10, 10, 10, 10)), Arrays.asList(10, 10, 10, 10, 10));
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(-10,-10,-10,-10,-10)), Arrays.asList(-10, -10, -10, -10, -10));
        assertEquals(bubbleSortUltimate.bubbleSort(null), null);
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(5, -10, 3, 0, -5)), Arrays.asList(-10, -5, 0, 3, 5));
        assertEquals(bubbleSortUltimate.bubbleSort(Arrays.asList(0)), Arrays.asList(0));
    }

    @After
    public void afterTest() {
        System.out.println("tset ok");
        System.out.println(new Date() + "\n" + "-------------------------");
    }
}