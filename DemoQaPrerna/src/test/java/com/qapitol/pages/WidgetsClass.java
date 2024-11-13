package com.qapitol.pages;

import com.qapitol.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WidgetsClass extends BaseClass {

    public void accordianClick(){
        //click on accordian
        driver.findElement(By.xpath("//span[text()='Accordian']")).click();
        WebElement a =driver.findElement(By.xpath("//div[text()='Where does it come from?']"));
        scrollTillTheElement(a);
        a.click();
        System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Contrary to popular belief, Lorem Ipsum is not sim')]")).getText());

//        System.out.println(driver.findElement(By.xpath("(//div[@class='card-body']//p)[2]")).getText());
//        System.out.println(s);
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

    public void toolTipsClick(){

    }

    public void menuClick(){

    }

    public void selectMenuClick(){

    }

}
