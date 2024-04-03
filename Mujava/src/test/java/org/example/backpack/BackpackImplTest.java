package org.example.backpack;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class BackpackImplTest extends TestCase {
    public static Backpack backpack;
    public List<Integer> input_weights;
    public List<Integer> input_values;
    public int capacity;
    public int expected;// 不合法的参数对应的预期默认都是0
    public int result;

    public BackpackImplTest(List<Integer> input_weights, List<Integer> input_values, int capacity, int expected) {
        this.expected = expected;
        this.capacity = capacity;
        this.input_weights = input_weights;
        this.input_values = input_values;
    }

    @BeforeClass
    public static void prepareForClass() {
        backpack = new BackpackImpl();
        System.out.println("----------------------------");
    }

    @Before
    public void prepare() {
        System.out.println("test begin");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                // 普通测试
                {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(5, 3, 4, 8, 6), 9, 17},
                {Arrays.asList(2, 3, 4, 5), Arrays.asList(3, 4, 5, 6), 9, 12},
                {Arrays.asList(5, 4, 7, 2, 3), Arrays.asList(3, 4, 5, 8, 6), 10, 18},
                {Arrays.asList(3, 4, 7, 2, 6), Arrays.asList(2, 6, 5, 3, 7), 8, 10},
                {Arrays.asList(6, 3, 5, 1, 2), Arrays.asList(6, 5, 4, 9, 7), 12, 27},
                // 特殊情况
                {Arrays.asList(2, 3, 4, 5), Arrays.asList(3, 4, 5, 6), 100, 18},// 总的重量小于背包容量
                {Arrays.asList(2, 3, 4, 5), Arrays.asList(3, 4, 5, 6), 1, 0},// 背包容量小于任何一个物品重量
                {Arrays.asList(2, 3, 4, -1), Arrays.asList(3, 4, 5, -1), -1, 0},// 背包容量不合法
                {Arrays.asList(6, 3, 5, 1, 2), Arrays.asList(6, 5, 4, 9, 7), 0, 0},// 容量为0
                {Arrays.asList(), Arrays.asList(7), 12, 0},// 重量是空
                {Arrays.asList(7), Arrays.asList(), 12, 0},// 价值是空
                {Arrays.asList(), Arrays.asList(), 12, 0},// 两方皆空
                {Arrays.asList(7), Arrays.asList(0), 12, 0},// 价值是0
                {Arrays.asList(0), Arrays.asList(1), 12, 0},// 重量是0
                {Arrays.asList(0), Arrays.asList(0), 12, 0},
                {null , null , 0 , 0}

        });
    }

    @Test
    public void backpackTest() {
        int result = backpack.backpack(this.input_weights, this.input_values, this.capacity);
        assertEquals(result, this.expected);
        assertTrue(result >= 0);
        this.result = result;
    }

    @After
    public void afterTest() {
        System.out.println("weights: " + this.input_weights + "\n" + "values:" + this.input_values + "\n"
                + "capacity: " + this.capacity + "\n" + "expected: " + this.expected + "\t" + "result: " + this.result);
        System.out.println("test ok!" + "\n");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("----------------------------" + "\n" + new Date());
    }


}