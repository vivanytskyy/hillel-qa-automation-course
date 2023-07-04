package com.gmail.ivanytskyy.vitaliy.rest.homework17.entities;

import lombok.*;
import java.util.List;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 02/07/2023
 */
@Data
public class Pet {
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;
}