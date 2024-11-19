package com.qapitol.pages;

import com.beust.ah.A;
import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class WidgetsClass extends BaseClass {

    public void accordianClick(){
        //click on accordian
        driver.findElement(By.xpath("//span[text()='Accordian']")).click();
        WebElement a =driver.findElement(By.xpath("//div[text()='Where does it come from?']"));
        scrollTillTheElement(a);
        a.click();
        System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Contrary to popular belief, Lorem Ipsum is not sim')]")).getText());
    }

    public void autoCompleteClick(){

    }

    public void sliderClick(){

    }

    public void datePickerClick(){

    }

    public void progressBarClick(){

    }

    public void tabsClick(){

    }

    public void toolTipsClick() throws InterruptedException {
        WebElement toolTip = driver.findElement(By.xpath("//span[text()='Tool Tips']"));
        scrollTillTheElement(toolTip);
        toolTip.click();

        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Tool Tips']")));

        WebElement toHover = driver.findElement(By.cssSelector("button#toolTipButton"));

        Actions a = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        a.moveToElement(toHover).build().perform();

        WebElement hoverEle = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
        System.out.println(hoverEle.getText());

    }

    public void menuClick(){
        WebElement toolTip = driver.findElement(By.xpath("//span[text()='Menu']"));
        scrollTillTheElement(toolTip);
        toolTip.click();

        scrollTillTheElement(driver.findElement(By.xpath("//h1[text()='Menu']")));

        WebElement mainItem2= driver.findElement(By.xpath("//a[text()='Main Item 2']"));
        Actions a = new Actions(driver);
        a.moveToElement(mainItem2).build().perform();

        WebElement subSubList2 = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        a.moveToElement(subSubList2).build().perform();

        driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']")).click();



    }

    public void selectMenuClick(){

    }

}
