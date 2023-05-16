package com.gmail.ivanytskyy.vitaliy.homework09.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 16/05/2023
 */
public class Cinderella {
    private final List<Integer> firstBasket;
    private final List<Integer> secondBasket;
    private final List<Integer> thirdBasket;

    public Cinderella(List<Integer> baseList,
                      Predicate<Integer> firstBasketCondition, Predicate<Integer> secondBasketCondition){
        if(baseList == null || baseList.isEmpty() || firstBasketCondition == null || secondBasketCondition == null )
            throw new IllegalArgumentException("Incorrect input values");
        this.firstBasket = new ArrayList<>();
        this.secondBasket = new ArrayList<>();
        this.thirdBasket = new ArrayList<>();
        sortListOfInts(baseList, firstBasketCondition, secondBasketCondition);
    }

    private void sortListOfInts(List<Integer> baseList,
                                Predicate<Integer> firstBasketCondition, Predicate<Integer> secondBasketCondition){
        for (Integer value : baseList) {
            if(firstBasketCondition.and(secondBasketCondition).test(value)){
                firstBasket.add(value);
                secondBasket.add(value);
            }else if(firstBasketCondition.test(value)){
                firstBasket.add(value);
            }else if (secondBasketCondition.test(value)){
                secondBasket.add(value);
            }else{
                thirdBasket.add(value);
            }
        }
    }

    public List<Integer> getFirstBasket() {
        return firstBasket;
    }

    public List<Integer> getSecondBasket() {
        return secondBasket;
    }

    public List<Integer> getThirdBasket() {
        return thirdBasket;
    }
}