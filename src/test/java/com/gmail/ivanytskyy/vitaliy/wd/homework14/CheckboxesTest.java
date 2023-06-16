package com.gmail.ivanytskyy.vitaliy.wd.homework14;

import com.gmail.ivanytskyy.vitaliy.pages.homework14.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * Task 3
 * Написати тест до сторінки:
 * https://the-internet.herokuapp.com/checkboxes - вивести на екран початковий стан чекбоксів (вибраний чи ні),
 * потім вибрати обидва.
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 16/06/2023
 */
public class CheckboxesTest extends BaseTest{

    @Test(description = "Task 3: work with checkboxes. Check an initial state.", priority = 10)
    public void checkboxesInitialStateTest(){
        CheckboxesPage checkboxesPage = openApp().openCheckboxesPage();
        System.out.println("Initial state:");
        System.out.println("Is checkbox 1 selected? " + checkboxesPage.isCheckBox1Selected());
        System.out.println("Is checkbox 2 selected? " + checkboxesPage.isCheckBox2Selected());
        Assert.assertFalse(checkboxesPage.isCheckBox1Selected());
        Assert.assertTrue(checkboxesPage.isCheckBox2Selected());
    }
    @Test(description = "Task 3: work with checkboxes. Select all the checkboxes.", priority = 20)
    public void selectCheckboxesTest(){
        CheckboxesPage checkboxesPage = openApp().openCheckboxesPage().selectCheckbox1().selectCheckbox2();
        Assert.assertTrue(checkboxesPage.isCheckBox1Selected());
        Assert.assertTrue(checkboxesPage.isCheckBox2Selected());
    }
}