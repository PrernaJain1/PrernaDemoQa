package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class ElementsClass extends BaseClass {

    public void textBoxCheck(){
        //Click on text box
        driver.findElement(By.className("text")).click();

        //asserting text box text
        String s = driver.findElement(By.className("text-center")).getText().trim();
        assertEquals(s, "Text Box");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Scrolling till full name
        scrollTillTheElement(driver.findElement(By.id("userName-label")));

        //send keys into full name
        driver.findElement(By.cssSelector("input[placeholder='Full Name']")).sendKeys(properties.getProperty("name"));

        //Send email
        driver.findElement(By.id("userEmail")).sendKeys(properties.getProperty("email"));

        //Current address
        driver.findElement(By.cssSelector("textarea.form-control[placeholder='Current Address']")).sendKeys(properties.getProperty("currAddress"));

        //Permanent address
        driver.findElement(By.id("permanentAddress")).sendKeys(properties.getProperty("perAddress"));

        //Scrolling till submit button
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        scrollTillTheElement(submitButton);
        //Submit button
        submitButton.click();
    }

    public void checkBoxCheck(){
        //Click on checkbox
        driver.findElement(By.xpath("//span[text()='Check Box']")).click();

        //click on first home checkbox
        driver.findElement(By.className("rct-checkbox")).click();

        //click on expand button
        driver.findElement(By.xpath("//button[@title='Toggle']")).click();

        //Checking documents checkbox is selected
        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[3]")).isSelected();

        //Unselect documents checkbox
        driver.findElement(By.xpath("(//span[@class='rct-checkbox'])[3]")).click();

        //To check documents text is displayed
        assertTrue(driver.findElement(By.xpath("//span[text()='Documents']")).isDisplayed());
    }

    public void radioButtonCheck() throws InterruptedException {
        //Click on radio button
        driver.findElement(By.xpath("//span[text()='Radio Button']")).click();

        sleep(5000);

        WebElement ele = driver.findElement(By.xpath("(//input[@type='radio'])[1]/.."));
        scrollTillTheElement(ele);

        //Click on yes button
        ele.click();

        //Is no button enabled
        assertFalse(driver.findElement(By.id("noRadio")).isEnabled());
    }

    public void buttonClick(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Click on buttons tab
        driver.findElement(By.xpath("//span[text()='Buttons']")).click();

        Actions a = new Actions(driver);

        //double click
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        scrollTillTheElement(doubleClickBtn);
        a.moveToElement(doubleClickBtn).doubleClick().build().perform();

        //Right click
        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn")) ;
        a.moveToElement(rightClickButton).contextClick().build().perform();

        //Normal click
        WebElement normalClick = driver.findElement(By.xpath("//button[text()='Click Me']"));
        a.moveToElement(normalClick).click().build().perform();
    }

    public void linkClick() throws InterruptedException {
        //Click on links
        driver.findElement(By.xpath("//span[text()='Links']")).click();

        //Scroll till first link
        WebElement element =driver.findElement(By.linkText("Home"));
        scrollTillTheElement(element);

        //click on first link
        element.click();

        Thread.sleep(5000);

        String parentTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();

        for(String tab: tabs){
            if(!tab.equals(parentTab)){
                driver.switchTo().window(tab);
            }
        }
        //Verify if tab got switched
        assertTrue(driver.findElement(By.xpath("//img[@src='/images/Toolsqa.jpg']")).isDisplayed());
    }

    public void webTablesClick(){

    }
    public void brokenLinksClick(){

    }
    public void uploadDownloadClick(){

    }
    public void dynamicPropertiesClick(){

    }
}
