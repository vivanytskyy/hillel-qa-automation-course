package com.gmail.ivanytskyy.vitaliy.wd.homework14;

import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

/*
 * Task 1
 * Написати тест до сторінки:
 * https://the-internet.herokuapp.com/challenging_dom - потрібно знайти і клікнути по кожній кнопці,
 * після чого вибрати всі значення з 4го стовбця таблиці і вивести їх на екран
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/06/2023
 */
public class ChallengingDomTest extends BaseTest{

    @Test(description = "Task 1: find the elements", priority = 10)
    public void clickOnButtonsTest(){
        openApp().openChallengingDomPage()
                .clickButton1()
                .clickButton2()
                .clickButton3();
    }
    @Test(description = "Task 1: print fourth column of the table)", priority = 20)
    public void printColumnOfTableTest(){
        List<String> expectedResult = List.of(
                "Definiebas0", "Definiebas1", "Definiebas2", "Definiebas3", "Definiebas4",
                "Definiebas5", "Definiebas6", "Definiebas7", "Definiebas8", "Definiebas9"
        );
        List<String> fourthColumnOfTable = openApp()
                .openChallengingDomPage()
                .getTextOfFourthColumn();
        fourthColumnOfTable.forEach(System.out::println);
        Assert.assertEquals(fourthColumnOfTable, expectedResult);
    }
}