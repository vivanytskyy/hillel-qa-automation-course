package com.gmail.ivanytskyy.vitaliy.rest.homework17;

import static com.gmail.ivanytskyy.vitaliy.rest.homework17.controllers.PetController.*;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.controllers.PetController;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.Pet;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.services.PetBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 02/07/2023
 */
public class PetTest {
    private PetController petController;
    @BeforeMethod
    public void setUp(){
        petController = new PetController();
    }
    @AfterMethod
    public void tearDown(){
        petController = null;
    }
    @Test(priority = 10)
    public void addPetTest() throws IOException {
        Pet defaultPet = new PetBuilder().build();
        Pet addedPet = petController.addPet(defaultPet);
        Assert.assertEquals(addedPet.toString(), defaultPet.toString());
    }
    @Test(priority = 20)
    public void updatePetTest() throws IOException {
        Pet defaultPet = new PetBuilder().build();
        Pet addedPet = petController.addPet(defaultPet);
        Assert.assertEquals(addedPet.toString(), defaultPet.toString());
        Pet changedPet = new PetBuilder()
                .setName("new_pet_name")
                .setPhotoUrls(
                        List.of("new_photo_url"))
                .setStatus(PetStatus.PENDING)
                .build();
        Pet updatedPet = petController.updatePet(changedPet);
        Assert.assertEquals(updatedPet.toString(), changedPet.toString());
    }
    @Test(priority = 30)
    public void findPetsByStatusTest() throws IOException {
        Pet[] resultPets = petController.findPetsByStatus(PetStatus.AVAILABLE);
        List<String> statusList = Arrays
                .stream(resultPets)
                .map(Pet::getStatus)
                .filter(status -> status.equals(PetStatus.AVAILABLE.toString().toLowerCase()))
                .toList();
        long statusNumber = statusList
                .stream()
                .filter(status -> status.equals(PetStatus.AVAILABLE.toString().toLowerCase()))
                .count();
        Assert.assertEquals(statusList.size(), resultPets.length);
        Assert.assertEquals(statusNumber, statusList.size());
    }
    @Test(priority = 40)
    public void findPetByIdTest() throws IOException {
        Pet defaultPet = new PetBuilder().build();
        Pet addedPet = petController.addPet(defaultPet);
        Assert.assertEquals(addedPet.toString(), defaultPet.toString());
        Long id = addedPet.getId();
        Pet resultPet = petController.findPetById(id);
        Assert.assertEquals(resultPet.getId(), id);
        Assert.assertEquals(resultPet.toString(), addedPet.toString());
    }
    @Test(priority = 50)
    public void updatePetByIdTest() throws IOException {
        Pet defaultPet = new PetBuilder().build();
        Pet addedPet = petController.addPet(defaultPet);
        Assert.assertEquals(addedPet.toString(), defaultPet.toString());
        Long targetId = addedPet.getId();
        String newName = "test_name";
        PetStatus newStatus =  PetStatus.PENDING;
        int code = petController.updatePetById(targetId, newName, newStatus);
        Assert.assertEquals(code, 200);
        Pet updatedPet = petController.findPetById(targetId);
        Assert.assertEquals(updatedPet.getId(), targetId);
        Assert.assertEquals(updatedPet.getName(), newName);
        Assert.assertEquals(updatedPet.getStatus(), newStatus.toString().toLowerCase());
        Assert.assertNotEquals(updatedPet.toString(), addedPet.toString());
    }
    @Test(priority = 60, enabled = false)
    public void uploadImageById() throws IOException {
        Pet defaultPet = new PetBuilder().build();
        Pet addedPet = petController.addPet(defaultPet);
        Assert.assertEquals(addedPet.toString(), defaultPet.toString());
        Long targetId = addedPet.getId();
        String additionalMetadata = "french bulldog";
        File file = new File("src" + File.separator
                + "test" + File.separator
                + "resources" + File.separator + "bulldog.jpg");
        int code = petController.uploadImageById(targetId, additionalMetadata, file);
        Assert.assertEquals(code, 200);
    }
    @Test(priority = 70)
    public void deletePetByIdTest() throws IOException {
        Pet defaultPet = new PetBuilder().build();
        Pet addedPet = petController.addPet(defaultPet);
        Assert.assertEquals(addedPet.toString(), defaultPet.toString());
        Long targetId = addedPet.getId();
        String apiKey = "special-key";
        int code = petController.deletePetById(targetId, apiKey);
        Assert.assertEquals(code, 200);
    }
}