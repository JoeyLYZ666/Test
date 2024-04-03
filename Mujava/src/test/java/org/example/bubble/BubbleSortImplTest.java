package org.example.bubble;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class BubbleSortImplTest extends TestCase {
    public static BubbleSort bubbleSort;
    public List<Integer> input;
    public List<Integer> expected;// 不合法的参数对应的预期默认都是0
    public List<Integer> result;

    public BubbleSortImplTest(List<Integer> input, List<Integer> expected) {
        this.expected = expected;
        this.input = input;
    }

    @BeforeClass
    public static void prepareForClass() {
        bubbleSort = new BubbleSortImpl();
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
                {Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5)},
                {Arrays.asList(2, 10, 4, 5), Arrays.asList(2, 4, 5, 10)},
                {Arrays.asList(-1, 4, 7, 2), Arrays.asList(-1, 2, 4, 7)},
                {Arrays.asList(5, 3, 8, 2, 1), Arrays.asList(1, 2, 3, 5, 8)},
                {Arrays.asList(5, 4, 3, 2, 1), Arrays.asList(1, 2, 3, 4, 5)},
                {Arrays.asList(6, 3, 15, 8, 12), Arrays.asList(3, 6, 8, 12, 15)},
                {Arrays.asList(10, 2, 33, 9, 100), Arrays.asList(2, 9, 10, 33, 100)},
                // 特殊情况
                {Arrays.asList(), Arrays.asList()},// 空处理
                {Arrays.asList(5), Arrays.asList(5)},// 单个元素处理
                {Arrays.asList(2, 3, 4, -1), Arrays.asList(-1, 2, 3, 4)},
                {Arrays.asList(10, 10, 10, 10, 10), Arrays.asList(10, 10, 10, 10, 10)},
                {Arrays.asList(-10,-10,-10,-10,-10), Arrays.asList(-10, -10, -10, -10, -10)},
                {Arrays.asList(5, -10, 3, 0, -5), Arrays.asList(-10, -5, 0, 3, 5)},
                {Arrays.asList(0), Arrays.asList(0)},
                {null, null},

        });
    }

    @Test
    public void bubbleSortTest() {
        bubbleSort.bubbleSort(this.input);
        this.result = this.input;
        assertEquals(this.input, this.expected);
    }

    @After
    public void afterTest() {
        System.out.println("input: " + this.input + "\n" + "exoected:" + this.expected + "\n"
                + "result: " + this.result);
        System.out.println("test ok!" + "\n");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("----------------------------" + "\n" + new Date());
    }

}