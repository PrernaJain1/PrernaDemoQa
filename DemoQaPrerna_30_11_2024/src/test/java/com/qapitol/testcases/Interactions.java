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
    public void sortableForList() throws InterruptedException {
        interactionsClass.sortableList();
    }

    @Test
    public void sortableForGrid() throws InterruptedException {
        interactionsClass.sortableGrid();
    }

    @Test
    public void selectableForList() throws InterruptedException {
        interactionsClass.selectableList();
    }

    @Test
    public void selectableForGrid() throws InterruptedException {
        interactionsClass.selectableGrid();
    }

    @Test
    public void resizeableFirst(){
        interactionsClass.resizable1();
    }

    @Test
    public void resizeableSecond(){
        interactionsClass.resizable2();
    }


    @Test
    public void droppable() {
        interactionsClass.droppableSimple();
    }

    @Test
    public void droppableForAccept() {
        interactionsClass.droppableAccept();
    }

    @Test
    public void droppablePrevent() {
        interactionsClass.droppablePreventPropagation();
    }

    @Test
    public void droppableRevert() {
        interactionsClass.droppableRevertDraggable();
    }

    @Test
    public void draggable(){
        interactionsClass.draggableSimple();
    }

    @Test
    public void draggableAxis(){
        interactionsClass.draggableAxisRestricted();
    }

    @Test
    public void draggableContainer(){
        interactionsClass.draggableContainerRestricted();
    }

//    @Test
    public void cursorStyle(){
        interactionsClass.draggableCursorStyle();
    }

    @AfterMethod
    public void setDown(){
        closing();
    }
}
