package com.gmail.ivanytskyy.vitaliy.homework11;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
* Tasks
* Написати декілька тестів, додати их до XML-конфіг файлу:
* 1. Тест на логін, який приймає ім'я користувача, його пароль та роль.
* Тестові дані потрібно сгенерувати через data provider, тест додати до групи login
* 2. Другий тест, який залежить від групи login.
* Можна додати умову, за якою тест1 буде фейлити, при йьому перевірити, як TestNG буде запускати залежний тест.
* 3. Тест, який приймає параметри ззовні (можна задати через XML-конфіг файл або рантайм) і виводить їх на екран
*/

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 28/05/2023
 */
public class ExampleTest {

    @Test(description = "Task 1",
            groups = {"login"},
            dataProvider = "userProvider",
            priority = 10)
    public void loginTest(String userName, String password, String role){
        System.out.printf("Task 1. name: %s, password: %s, role: %s\n", userName, password, role);
        System.out.println("Start test for " + role);
        //if(role.equals("guest")) throw new RuntimeException("test for " + role + " failed");
        System.out.println("Finish test for " + role);
    }

    @Test(description = "Task 2",
            dependsOnGroups = {"login"},
            priority = 20)
    public void doSomethingDependOnAnotherTest(){
        System.out.println("Task 2. This test depends on the login group");
    }

    @Test(description = "Task 3", priority = 30)
    @Parameters({"url", "browser"})
    public void getParamsTest(String url, String browser){
        System.out.println("Task 3. URL: " + url + ", browser name: " + browser);
    }

    @DataProvider(name = "userProvider")
    public Object[][] userProvider(){
        return new String[][]{
                {"userName", "userPass", "user"},
                {"guestName", "guestPass", "guest"},
                {"adminName", "adminPass", "admin"}
        };
    }
}