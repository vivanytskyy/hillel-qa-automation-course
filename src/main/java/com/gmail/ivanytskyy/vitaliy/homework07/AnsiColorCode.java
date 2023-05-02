package com.gmail.ivanytskyy.vitaliy.homework07;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 29/04/2023
 */
public enum AnsiColorCode {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m");
    private final String ansiCode;

    AnsiColorCode(String ansiCode){
        this.ansiCode = ansiCode;
    }

    public String getCode(){
        return ansiCode;
    }
}
