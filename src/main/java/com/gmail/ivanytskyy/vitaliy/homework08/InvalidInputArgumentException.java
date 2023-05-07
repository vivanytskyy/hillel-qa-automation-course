package com.gmail.ivanytskyy.vitaliy.homework08;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 06/05/2023
 */
public class InvalidInputArgumentException extends RuntimeException{
    public InvalidInputArgumentException(String message) {
        super(message);
    }
}