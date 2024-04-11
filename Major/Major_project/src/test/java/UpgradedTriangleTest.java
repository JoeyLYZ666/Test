import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UpgradedTriangleTest {
    public UpgradedTriangle upgradedTriangle;

    @Before
    public void prepare() {
        this.upgradedTriangle = new UpgradedTriangle();
        System.out.println("----------------------");
    }

    @Test
    public void Test() {
        double epsilon = 0.0001;//精度
        // INVALID
        assertEquals(upgradedTriangle.classifyTriangle(2, 2, -1), "INVALID");// 负数
        assertEquals(upgradedTriangle.getArea(2, 2, -1), 0, epsilon);// 负数

        assertEquals(upgradedTriangle.classifyTriangle(0, 0, 1), "INVALID");// 0
        assertEquals(upgradedTriangle.getArea(0, 0, 1), 0, epsilon);// 0

        assertEquals(upgradedTriangle.classifyTriangle(1, 2, 1), "INVALID");// 边长不符合要求
        assertEquals(upgradedTriangle.getArea(1, 2, 1), 0, epsilon);// 边长不符合要求

        assertEquals(upgradedTriangle.classifyTriangle(null, 2, 1), "INVALID");// null
        assertEquals(upgradedTriangle.getArea(null, 2, 1), 0, epsilon);// null

        assertEquals(upgradedTriangle.classifyTriangle(0, 0, 0), "INVALID");// 三个0不是等边
        assertEquals(upgradedTriangle.getArea(0, 0, 0), 0, epsilon);// 三个0不是等边

        assertEquals(upgradedTriangle.classifyTriangle(-10000, -10000, -10000), "INVALID");// 三个0不是等边
        assertEquals(upgradedTriangle.getArea(-10000, -10000, -10000), 0, epsilon);// 三个0不是等边

        // EQUILATERAL
        assertEquals(upgradedTriangle.classifyTriangle(2, 2, 2), "EQUILATERAL");
        assertEquals(upgradedTriangle.getArea(2, 2, 2), Math.sqrt(3), epsilon);

        assertEquals(upgradedTriangle.classifyTriangle(1, 1, 1), "EQUILATERAL");
        assertEquals(upgradedTriangle.getArea(1, 1, 1), Math.sqrt((double) 3 / 16), epsilon);

        assertEquals(upgradedTriangle.classifyTriangle(128, 128, 128), "EQUILATERAL");
        assertEquals(upgradedTriangle.getArea(128, 128, 128), Math.pow(128, 2) * Math.sqrt(3) / 4, epsilon);

        assertEquals(upgradedTriangle.classifyTriangle(22, 22, 22), "EQUILATERAL");
        assertEquals(upgradedTriangle.getArea(22, 22, 22), Math.pow(11, 2) * Math.sqrt(3), epsilon);

        // ISOSCELES
        assertEquals(upgradedTriangle.classifyTriangle(2, 2, 1), "ISOSCELES");
        assertEquals(upgradedTriangle.getArea(2, 2, 1), Math.sqrt(15) / 4, epsilon);

        assertEquals(upgradedTriangle.classifyTriangle(2, 2, 3), "ISOSCELES");
        assertEquals(upgradedTriangle.getArea(2, 2, 3), Math.sqrt(63) / 4, epsilon);

        assertEquals(upgradedTriangle.classifyTriangle(7, 7, 10), "ISOSCELES");
        assertEquals(upgradedTriangle.getArea(7, 7, 10), Math.sqrt(600), epsilon);

        assertEquals(upgradedTriangle.classifyTriangle(3, 5, 3), "ISOSCELES");
        assertEquals(upgradedTriangle.getArea(3, 5, 3), Math.sqrt(275) / 4, epsilon);

        // SCALENE
        assertEquals(upgradedTriangle.classifyTriangle(5, 4, 3), "SCALENE");
        assertEquals(upgradedTriangle.getArea(5, 4, 3), 6, epsilon);

        assertEquals(upgradedTriangle.classifyTriangle(10, 6, 8), "SCALENE");
        assertEquals(upgradedTriangle.getArea(10, 6, 8), 24, epsilon);

        assertEquals(upgradedTriangle.classifyTriangle(6, 2, 5), "SCALENE");
        assertEquals(upgradedTriangle.getArea(6, 2, 5), Math.sqrt(351) / 4, epsilon);

        assertEquals(upgradedTriangle.classifyTriangle(10, 13, 22), "SCALENE");
        assertEquals(upgradedTriangle.getArea(10, 13, 22), Math.sqrt(21375) / 4, epsilon);

    }

    @After
    public void after() {
        System.out.println("test ok!\n" + new Date());
        System.out.println("----------------------");
    }


}