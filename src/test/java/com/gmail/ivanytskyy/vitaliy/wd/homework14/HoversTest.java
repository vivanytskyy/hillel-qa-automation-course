package com.gmail.ivanytskyy.vitaliy.wd.homework14;

import com.gmail.ivanytskyy.vitaliy.pages.homework14.HoversPage;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * Task 3
 * Написати тест до сторінки:
 * https://the-internet.herokuapp.com/hovers - написати тест, який виводить юзернейм для кожного користувача
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/06/2023
 */
public class HoversTest extends BaseTest{

    @Test(description = "Check user names by actions", priority = 10)
    public void findUserNamesTest(){
        HoversPage hoversPage = openApp().openHoversPage();
        Assert.assertEquals(hoversPage.getNameUser1(), "user1");
        Assert.assertEquals(hoversPage.getNameUser2(), "user2");
        Assert.assertEquals(hoversPage.getNameUser3(), "user3");
    }
}