package com.gmail.ivanytskyy.vitaliy.homework04;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

/*
* Task 1
* Написати програму, яка друкує таблицю значень sin(x), де х - кожні 10 градусів від 0 до 360
*
* Task 2
* Написати програму, яка в масиві з випадкових цілих чисел замінює всі парні числа на 0 і виводить отриманий масив на екран.
* Для генерації випадкових чисел можна користуватись Random:
* Random random = new Random;
* int i = random.nextInt(100); //случайное целое число до 100
*
* Task 3
* Написати програму, яка обчислює середнє арифметичне значення всіх елементів у масиві з 20 випадкових чисел
*/
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 13/04/2023
 */
public class TrivialTasks {

    public static void main(String[] args) {
        // Task 1
        System.out.println("Task 1");
        String line = "-".repeat(34);
        String labelFormat = "|%1$7s" + "x" + "%1$7s|%1$5s" + "sin(x)" + "%1$5s|\n";
        for(int i = 0; i <= 360; i += 10){
            if(i == 0){
                System.out.println(line);
                System.out.printf(labelFormat, " ");
                System.out.println(line);
            }

            double sinValue = Math.sin(Math.toRadians(i));
            // We can use BigDecimal for avoid unexpected results (for example: sin(360°) = -0.000 )
            BigDecimal bd = BigDecimal.valueOf(sinValue).setScale(3, RoundingMode.HALF_UP);
            int xLength = (i == 0) ? 1 : (i < 100) ? 2 : 3;
            int sinXLength = bd.doubleValue() >= 0 ? 5 : 6;
            String format = "|%1$7s%2$d%1$" + (8 - xLength) + "s|%1$5s%3$.3f%1$" + (11 - sinXLength) + "s|\n";
            System.out.printf(format, " ", i, bd.doubleValue());
            System.out.println(line);
        }

        // Task 2
        System.out.println("Task 2");
        int[] intArray = createArrayWithRandomValues(10);
        for (int i = 0; i < intArray.length; i++) {
            if(intArray[i] % 2 == 0) intArray[i] = 0;
        }
        System.out.println("Array values: " + Arrays.toString(intArray));

        // Task 3
        System.out.println("Task 3");
        int[] array = createArrayWithRandomValues(20);
        // 1-st variant: implementation by foreach
        double sum = 0;
        for (int value : array){
            sum += value;
        }
        double avgV1 = sum / array.length;
        System.out.printf("Version 1 (by foreach): AVG = %.2f\n", avgV1);
        // 2-nd variant: implementation by stream
        double avgV2 = Arrays.stream(array).average().orElseThrow(IllegalArgumentException::new);
        System.out.printf("Version 2 (by stream): AVG = %.2f\n", avgV2);
    }

    private static int[] createArrayWithRandomValues(int arrayLength ){
        if(arrayLength <= 0) throw new IllegalArgumentException("Incorrect input value: " + arrayLength);
        int[] intArray = new int[arrayLength];
        Random randomGen = new Random();
        for(int i = 0; i < intArray.length; i++){
            intArray[i] = randomGen.nextInt(100);
        }
        return intArray;
    }
}
