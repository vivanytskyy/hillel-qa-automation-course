package com.gmail.ivanytskyy.vitaliy.homework06;

/*
 * Task 4
 * Написати новий клас (чи класи), які можна використати для задачі з покером, яку розглянули на попередньому занятті.
 * Інтегрувати ці класи і переписати програму з ними.
 * Результат виконання завдання - посилання на пулл-реквест в репозиторії на GitHub
 */
/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 22/04/2023
 */
public class PokerCasino {

    public static void main(String[] args) {
        Player[] players = {
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4")
        };
        int cardsForPlayers = 5;
        CardDeck cardDeck = new FrenchSuitedDeck();
        DealerMachine dealerMachine = new DealerMachine(players, cardsForPlayers, cardDeck);
        dealerMachine.distributeTheCards();
    }
}