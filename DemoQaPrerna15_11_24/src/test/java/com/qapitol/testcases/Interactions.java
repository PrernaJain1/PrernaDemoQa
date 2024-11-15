package com.qapitol.testcases;

import com.qapitol.pages.HomePageClass;
import com.qapitol.pages.InteractionsClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.qapitol.base.BaseClass.*;

public class Interactions {

    HomePageClass home;
    InteractionsClass interactionsClass;


    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        initializer();

        home =new HomePageClass();
        interactionsClass = new InteractionsClass();
        home.clickOnInteractions();

        Thread.sleep(5000);

        WebElement ele1 = driver.findElement(By.xpath("//div[text()='Interactions']"));
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",ele1);
    }

    @Test
    public void sortable() throws InterruptedException {
        interactionsClass.sortableList();
        interactionsClass.sortableGrid();
    }

    @Test
    public void selectable() throws InterruptedException {
        interactionsClass.selectableList();
        interactionsClass.selectableGrid();
    }

    @Test
    public void resizeable(){
        interactionsClass.resizable1();
        interactionsClass.resizable2();
    }

    @Test
    public void droppable() {
        interactionsClass.droppableSimple();
        interactionsClass.droppableAccept();
        interactionsClass.droppablePreventPropagation();
        interactionsClass.droppableRevertDraggable();
    }

    @Test
    public void draggable(){
//        interactionsClass.draggableSimple();
//        interactionsClass.draggableAxisRestricted();
//        interactionsClass.draggableContainerRestricted();
        interactionsClass.draggableCursorStyle();
    }

    @AfterMethod
    public void setDown(){
        closing();
    }
}
