package org.example.backpack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BackPackUltimateTest {
    public BackpackUltimate backPackUltimate;

    @Before
    public void prepare() {
        backPackUltimate = new BackpackUltimate();
        System.out.println("-------------------------");
    }

    @Test
    public void backpackTest() {
        // 普通测试
        assertEquals(backPackUltimate.backpack(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(5, 3, 4, 8, 6), 9), 17);
        assertEquals(backPackUltimate.backpack(Arrays.asList(2, 3, 4, 5), Arrays.asList(3, 4, 5, 6), 9), 12);
        assertEquals(backPackUltimate.backpack(Arrays.asList(5, 4, 7, 2, 3), Arrays.asList(3, 4, 5, 8, 6), 10), 18);
        assertEquals(backPackUltimate.backpack(Arrays.asList(3, 4, 7, 2, 6), Arrays.asList(2, 6, 5, 3, 7), 8), 10);
        assertEquals(backPackUltimate.backpack(Arrays.asList(6, 3, 5, 1, 2), Arrays.asList(6, 5, 4, 9, 7), 12), 27);
        // 特殊情况
        assertEquals(backPackUltimate.backpack(Arrays.asList(2, 3, 4, 5), Arrays.asList(3, 4, 5, 6), 100), 18);// 总的重量小于背包容量
        assertEquals(backPackUltimate.backpack(Arrays.asList(2, 3, 4, 5), Arrays.asList(3, 4, 5, 6), 1), 0);// 背包容量小于任何一个物品重量
        assertEquals(backPackUltimate.backpack(Arrays.asList(2, 3, 4, -1), Arrays.asList(3, 4, 5, -1), -1), 0);// 背包容量不合法
        assertEquals(backPackUltimate.backpack(Arrays.asList(6, 3, 5, 1, 2), Arrays.asList(6, 5, 4, 9, 7), 0), 0);// 背包容量不合法

        assertEquals(backPackUltimate.backpack(Arrays.asList(), Arrays.asList(7), 12), 0);// 重量是空
        assertEquals(backPackUltimate.backpack(Arrays.asList(7), Arrays.asList(), 12), 0);// 价值是空
        assertEquals(backPackUltimate.backpack(Arrays.asList(), Arrays.asList(), 12), 0);
        assertEquals(backPackUltimate.backpack(Arrays.asList(7), Arrays.asList(0), 12), 0);// 价值是0
        assertEquals(backPackUltimate.backpack(Arrays.asList(0), Arrays.asList(1), 12), 0);
        assertEquals(backPackUltimate.backpack(Arrays.asList(0), Arrays.asList(0), 12), 0);
        assertEquals(backPackUltimate.backpack(null , null , 0), 0);
    }

    @After
    public void after() {
        System.out.println("tset ok");
        System.out.println(new Date() + "\n" + "-------------------------");
    }
}