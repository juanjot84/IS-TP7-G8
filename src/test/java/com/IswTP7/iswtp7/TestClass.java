package com.IswTP7.iswtp7;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.JavascriptExecutor;

public class TestClass {

    private WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
    }

    @Test
    @Order(1)
    public void testGooglePage() {
        driver.get("https://www.google.com");
        WebElement searchbox = driver.findElement(By.name("q"));

        searchbox.clear();
        searchbox.sendKeys("River campeón");
        searchbox.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertEquals("River campeón - Buscar con Google", driver.getTitle());
    }

    @Test
    @Order(2)
    public void ejercicio1() {
        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(By.id("login2")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.id("loginusername")).click();
        driver.findElement(By.id("loginusername")).sendKeys("xyjvoepfjvivxxbtgt@mrvpt.com");
        driver.findElement(By.id("loginpassword")).click();
        driver.findElement(By.id("loginpassword")).sendKeys("ABC123");
        // Aca falla por que no puede hacer click en el boton login
        driver.findElement(By.cssSelector("#logInModal .btn-primary")).click();
        assertEquals("Welcome xyjvoepfjvivxxbtgt@mrvpt.com", driver.findElement(By.id("nameofuser")).getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
