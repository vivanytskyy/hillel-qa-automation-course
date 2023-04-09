package com.gmail.ivanytskyy.vitaliy.homework03;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 08/04/2023
 */
public class Triangle {
    public static final String EXCEPTION_MESSAGE = "Incorrect input value";
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        if (!isInputDataValid(a, b, c)) throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getPerimeter(){
        return a + b + c;
    }

    public boolean isIsosceles(){
        return a == b || a == c || b == c;
    }

    public boolean isEquilateral(){
        return a == b && a == c && b == c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    //A triangle is valid if sum of its two sides is greater than the third side.
    private boolean isInputDataValid(double a, double b, double c){
        return (a > 0 && b > 0 && c > 0) && (a + b > c && a + c > b && b + c > a);
    }
}
