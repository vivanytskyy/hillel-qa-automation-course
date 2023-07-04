package com.gmail.ivanytskyy.vitaliy.rest.homework17;

import com.gmail.ivanytskyy.vitaliy.rest.homework17.controllers.UserController;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.User;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.services.UserBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 04/07/2023
 */
public class UserTest {
    private UserController userController;
    @BeforeMethod
    public void setUp(){
        this.userController = new UserController();
    }
    @AfterMethod
    public void tearDown(){
        userController = null;
    }
    @Test(priority = 10)
    public void createUserTest() throws IOException {
        User defaultUser = new UserBuilder().build();
        int code = userController.createUser(defaultUser);
        Assert.assertEquals(code, 200);
    }
    @Test(priority = 20)
    public void createUsersWithArrayTest() throws IOException {
        User user1 = new UserBuilder().setUsername("user1").build();
        User user2 = new UserBuilder().setUsername("user2").build();
        User user3 = new UserBuilder().setUsername("user3").build();
        User[] users = {user1, user2, user3};
        int code = userController.createUsersWithArray(users);
        Assert.assertEquals(code, 200);
    }
    @Test(priority = 30)
    public void createUsersWithList() throws IOException {
        User user1 = new UserBuilder().setUsername("user1").build();
        User user2 = new UserBuilder().setUsername("user2").build();
        User user3 = new UserBuilder().setUsername("user3").build();
        List<User> users = List.of(user1, user2, user3);
        int code = userController.createUsersWithList(users);
        Assert.assertEquals(code, 200);
    }
    @Test(priority = 40)
    public void getUserByUsernameTest() throws IOException {
        User defaultUser = new UserBuilder().build();
        int code = userController.createUser(defaultUser);
        Assert.assertEquals(code, 200);
        User resultUser = userController.getUserByUsername(defaultUser.getUsername());
        Assert.assertEquals(resultUser.toString(), defaultUser.toString());
    }
    @Test(priority = 50)
    public void updateUserByUsernameTest() throws IOException {
        User defaultUser = new UserBuilder().build();
        int createCode = userController.createUser(defaultUser);
        Assert.assertEquals(createCode, 200);
        User userForUpdate = userController.getUserByUsername(defaultUser.getUsername());
        Assert.assertEquals(userForUpdate.toString(), defaultUser.toString());
        userForUpdate.setFirstName("Kit");
        userForUpdate.setLastName("Harington");
        int updateCode = userController.updateUserByUsername(userForUpdate.getUsername(), userForUpdate);
        Assert.assertEquals(updateCode, 200);
        User updatedUser = userController.getUserByUsername(userForUpdate.getUsername());
        Assert.assertEquals(updatedUser.toString(), userForUpdate.toString());
    }
    @Test(priority = 60)
    public void deleteUserByUsernameTest() throws IOException {
        User defaultUser = new UserBuilder().build();
        int createCode = userController.createUser(defaultUser);
        Assert.assertEquals(createCode, 200);
        int deleteCode = userController.deleteUserByUsername(defaultUser.getUsername());
        Assert.assertEquals(deleteCode, 200);
    }
    @Test(priority = 70)
    public void loginTest() throws IOException {
        User defaultUser = new UserBuilder().build();
        int createCode = userController.createUser(defaultUser);
        Assert.assertEquals(createCode, 200);
        int loginCode = userController.login(defaultUser.getUsername(), "default_password");
        Assert.assertEquals(loginCode, 200);
    }
    @Test(priority = 80)
    public void logoutTest() throws IOException {
        int logoutCode = userController.logout();
        Assert.assertEquals(logoutCode, 200);
    }
}