package org.example.webtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BaiduTest {
    public static WebDriver webDriver;

    @BeforeAll
    public static void setup() {
        Path path = Paths.get("src/main/java/org/example", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.toString()); //设置系统属性
        webDriver = new ChromeDriver();//创建实例

    }

    @Test
    public void test() throws InterruptedException {
        webDriver.get("https://www.baidu.com");//导航到百度上
        webDriver.findElement(By.id("kw")).sendKeys("selenium");//kw:搜索框
        webDriver.findElement(By.id("su")).click();//点击搜索
//        webDriver.findElement(By.className("bg")).click();//表示查找具有class属性为"bg"的HTML元素再点击
        Thread.sleep(3000);//等待页面加载完全

        //统计条目数量
        List<WebElement> searchResults = webDriver.findElements(By.cssSelector("h3"));//标题
        System.out.println("搜索结果数量是：" + searchResults.size());
        //输出结果的标题
        System.out.println("--------------------------------条目标题-------------------------------");
        for (WebElement result : searchResults) {
            System.out.print(result.getText());
            if (result.getText().toLowerCase().contains("selenium"))
                System.out.println(">>>>>>>>包含selenium（不区分大小写）\n");
            else
                System.out.println("\n");
        }
        System.out.println("----------------------------------结束---------------------------------");
    }

    @AfterAll
    public static void quit() {
        webDriver.quit();
    }

}
