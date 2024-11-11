package com.qapitol.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.internal.ReporterConfig;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties properties;

    @BeforeMethod
    public static void initializer() throws IOException {
        driver= new ChromeDriver();
        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();

        FileReader reader = new FileReader("src//test//resources//application.properties");
        properties= new Properties();
        properties.load(reader);
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public static void closing(){
        driver.quit();
    }
}
