package org.example.webtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    public static WebDriver webDriver;
    public String username;
    public String password;

    @BeforeAll
    public static void setup() {
        Path path = Paths.get("src/main/java/org/example", "drivers", "chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", path.toString());
        webDriver = new ChromeDriver();
    }

    @BeforeEach
    public void setupForeach() {
        webDriver.get(" https://the-internet.herokuapp.com/login");
        System.out.println("--------------------------------------");
    }

    @Test
    public void test1(){
        this.password = "SuperSecretPassword!";
        this.username = "tomsmith";
        webDriver.findElement(By.id("username")).sendKeys("tomsmith");
        webDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        webDriver.findElement(By.className("radius")).click();
        int size = webDriver.findElements(By.className("success")).size();
        //flash success是两个类名的组合，需要使用
        assertEquals(1, size);
        webDriver.findElement(By.className("icon-signout")).click();//退出
        size = webDriver.findElements(By.className("success")).size();
        assertEquals(1, size);//退出成功验证
    }

    @Test
    public void test2(){
        this.password = "SuperSecretPassword!";
        this.username = "1";
        webDriver.findElement(By.id("username")).sendKeys("1");
        webDriver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        webDriver.findElement(By.className("radius")).click();
        int size = webDriver.findElements(By.className("error")).size();
        //flash success是两个类名的组合，需要使用
        assertEquals(1, size);
    }

    @Test
    public void test3()  {
        this.password = "1";
        this.username = "tomsmith";
        webDriver.findElement(By.id("username")).sendKeys("tomsmith");
        webDriver.findElement(By.id("password")).sendKeys("1");
        webDriver.findElement(By.className("radius")).click();
        int size = webDriver.findElements(By.className("error")).size();
        //flash success是两个类名的组合，需要使用
        assertEquals(1, size);
    }

    @Test
    public void test4() {
        this.password = "1!";
        this.username = "1";
        webDriver.findElement(By.id("username")).sendKeys("1");
        webDriver.findElement(By.id("password")).sendKeys("1");
        webDriver.findElement(By.className("radius")).click();
        int size = webDriver.findElements(By.className("error")).size();
        //flash success是两个类名的组合，需要使用
        assertEquals(1, size);
    }
    @AfterEach
    public void afterEach() throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("username: " + this.username);
        System.out.println("password: " + this.password);
        if(username.equals("tomsmith") && password.equals("SuperSecretPassword!"))
            System.out.println(">>>>>>>> login success >>>>>>>>");
        else
            System.out.println(">>>>>>>>> login error  >>>>>>>>>");
    }

    @AfterAll
    public static void quit() throws InterruptedException {
        Thread.sleep(1000);
        webDriver.quit();
        System.out.println("--------------------------------------\n" + new Date());
    }
}
