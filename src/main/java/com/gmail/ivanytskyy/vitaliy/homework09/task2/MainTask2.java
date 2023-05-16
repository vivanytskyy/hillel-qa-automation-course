package com.gmail.ivanytskyy.vitaliy.homework09.task2;
/*
 * Task 2
 * Створити програму - список покупок. В список заносяться назва товару та кількість.
 * Список заповнити випадковими товарами. В кінці потрібно підрахувати загальну кількість всіх доданих товарів
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 15/05/2023
 */
public class MainTask2 {
    public static void main(String[] args) {
        MainTask2 task = new MainTask2();
        Map<String, Integer> goods = task.generateGoods(1000, 2, 5);
        int count = 0;
        for(Integer value : goods.values()){
            count += value;
        }
        System.out.println("Goods (catalog): " + goods.keySet());
        System.out.println("Goods list size : " + goods.size());
        System.out.println("Total quantity of goods: " + count);
    }
    private Map<String, Integer> generateGoods(int goodsListSize, int minGoodsNameLength, int maxGoodsNameLength){
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<String, Integer> goods = new HashMap<>();
        Random random = new Random();
        for(int i = 0; i < goodsListSize; i++){
            StringBuilder sb = new StringBuilder();
            int nameLength = random.nextInt(minGoodsNameLength, maxGoodsNameLength + 1);
            for(int j = 0; j < nameLength; j++){
                int charNumber = random.nextInt(0, alphabet.length());
                sb.append(alphabet.charAt(charNumber));
            }
            String key = sb.toString();
            if(goods.containsKey(key)) {
                goods.put(key, goods.get(key) + 1);
                i--;
            }else {
                goods.put(key, 1);
            }
        }
        return goods;
    }
}