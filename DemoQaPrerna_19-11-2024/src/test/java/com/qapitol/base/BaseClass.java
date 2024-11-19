package com.qapitol.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties properties;

    public static void initializer() throws IOException {
        driver= new ChromeDriver();

        driver.manage().window().maximize();
        FileReader reader = new FileReader("src//test//resources//application.properties");
        properties= new Properties();
        properties.load(reader);
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().deleteAllCookies();
    }

    public void scrollTillTheElement(WebElement element){
        JavascriptExecutor script = (JavascriptExecutor) driver;
        script.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public static void closing(){
        driver.quit();
    }
}
