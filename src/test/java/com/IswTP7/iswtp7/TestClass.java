package com.IswTP7.iswtp7;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    public void ejercicio1() {
        driver.get("https://www.musimundo.com/");
        driver.findElement(By.cssSelector(".mus-header-user .mus-link1")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".mus-header-user .mus-link1"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        // Se agrega un retardo porque si no ha cargado la página da error
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.id("j_username")).click();
        driver.findElement(By.id("j_username")).sendKeys("ottxsobckjdjgxuflk@mrvpt.com");
        driver.findElement(By.id("j_password")).click();
        driver.findElement(By.id("j_password")).sendKeys("123ABC");
        driver.findElement(By.cssSelector(".form-actions:nth-child(2) > .positive")).click();
        assertThat(driver.findElement(By.cssSelector(".mus-header-user .mus-he-account-intro")).getText(), is("Hola, Juan"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
