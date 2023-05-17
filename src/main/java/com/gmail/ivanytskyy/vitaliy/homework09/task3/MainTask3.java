package com.gmail.ivanytskyy.vitaliy.homework09.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

/*
 * Task 3
 * Написати програму, яка замість попелюшки сортує числа з початкової колекції на 3 кошика:
 * в перший - числа, які діляться на 2,
 * в другий - числа, які діляться на 3,
 * в третій - всі інші.
 * Якщо число ділиться на 2 і на 3, то воно має попасти в обидва кошика.
 * Початкову колекцію з 100 елементів заповнити випадковими цілими числами.
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/05/2023
 */
public class MainTask3 {

    public static void main(String[] args) {
        MainTask3 task = new MainTask3();
        Predicate<Integer> firstBasketCondition = n -> n % 2 == 0;
        Predicate<Integer> secondBasketCondition = n -> n % 3 == 0;
        List<Integer> baseList = task.generateListOfInts(10, 1, 100);
        Cinderella cinderella = new Cinderella(baseList, firstBasketCondition, secondBasketCondition);
        System.out.println("Base list of integers: " + baseList);
        System.out.println("First basket (n%2=0): " + cinderella.getFirstBasket());
        System.out.println("Second basket (n%3=0): " + cinderella.getSecondBasket());
        System.out.println("Third basket (others n): " + cinderella.getThirdBasket());
    }

    private List<Integer> generateListOfInts(int size, int minValue, int maxValue){
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++){
            list.add(random.nextInt(minValue, maxValue + 1));
        }
        return list;
    }
}