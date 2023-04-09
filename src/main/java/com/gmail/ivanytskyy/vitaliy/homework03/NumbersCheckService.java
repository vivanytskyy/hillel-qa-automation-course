package com.gmail.ivanytskyy.vitaliy.homework03;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 08/04/2023
 */
public class NumbersCheckService {
    public static final String EXCEPTION_MESSAGE = "Incorrect input value";
    public static final String ODD_NUMBER_MESSAGE = "Odd number";
    public static final String EVEN_NUMBER_MESSAGE = "Even number";
    public static final String EQUAL_VALUES_MESSAGE = "Values is equal";

    public String checkOddOrEven(int num){
        if(num < 1) throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        return num % 2 == 0 ? EVEN_NUMBER_MESSAGE : ODD_NUMBER_MESSAGE;
    }

    public String compareAbsValues(int num1, int num2){
        // Arg values must not be less than Integer.MIN_VALUE - 1
        if(num1 == Integer.MIN_VALUE || num2 == Integer.MIN_VALUE) throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        String result;
        int absNum1 = Math.abs(num1);
        int absNum2 = Math.abs(num2);
        if(absNum1 > absNum2){
            result = "Absolute value of " + num1 + " more than " + num2;
        }else if (absNum1 < absNum2){
            result = "Absolute value of " + num2 + " more than " + num1;
        }else{
            result = EQUAL_VALUES_MESSAGE;
        }
        return result;
    }
}
