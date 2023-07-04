package com.gmail.ivanytskyy.vitaliy.rest.homework17.services;

import com.gmail.ivanytskyy.vitaliy.rest.homework17.controllers.PetController;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.Category;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.Pet;
import com.gmail.ivanytskyy.vitaliy.rest.homework17.entities.Tag;
import java.util.List;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 03/07/2023
 */
public class PetBuilder {
    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public PetBuilder() {
        this.id = 111L;
        this.category = new Category();
        this.category.setId(222L);
        this.category.setName("default_category_name");
        this.name = "default_pet_name";
        this.photoUrls = List.of("default_photo_url");
        Tag tag = new Tag();
        tag.setId(111L);
        tag.setName("default_tag_name");
        this.tags = List.of(tag);
        this.status = PetController.PetStatus.AVAILABLE.toString().toLowerCase();
    }
    public Pet build() {
        Pet pet = new Pet();
        pet.setId(this.id);
        pet.setCategory(this.category);
        pet.setName(this.name);
        pet.setPhotoUrls(this.photoUrls);
        pet.setTags(this.tags);
        pet.setStatus(this.status);
        return pet;
    }
    public PetBuilder setId(Long id) {
        this.id = id;
        return this;
    }
    public PetBuilder setCategory(Category category) {
        this.category = category;
        return this;
    }
    public PetBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PetBuilder setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }
    public PetBuilder setTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }
    public PetBuilder setStatus(PetController.PetStatus status) {
        this.status = status.toString().toLowerCase();
        return this;
    }
}