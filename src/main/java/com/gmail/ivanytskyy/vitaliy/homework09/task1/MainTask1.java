package com.gmail.ivanytskyy.vitaliy.homework09.task1;

import java.util.*;
import static com.gmail.ivanytskyy.vitaliy.homework09.task1.ListCleanService.SolveBy.*;

/*
* Task 1
* Написати програму яка видаляє з колекції цілих чисел всі дублікати, якщо вони є.
* Початкову колекцію з 100 елементів потрібно заповнити випадковими числами (ліміт 50).
* На екран потрібно вивести обидві колекції та кількість видалених дублікатів.
* (За бажанням можна вирішити декількома способами та порівняти, який з них швидше)
*/

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 13/05/2023
 */
public class MainTask1 {

    public static void main(String[] args) {
        MainTask1 task = new MainTask1();
        Map<ListCleanService.SolveBy, Long> executionTimeReport = new LinkedHashMap<>();
        List<Integer> intArrayListFull = task.fillIntsList(new ArrayList<>(), 100, 50);
        List<Integer> intLinkedListFull = task.fillIntsList(new LinkedList<>(), 100, 50);

        ListCleanService<Integer> cleaner;

        // Case 1 - clean by add unique values in new ArrayList (iteration)
        cleaner = new ListCleanService<>(ADD_UNIQUE_VALUE_IN_NEW_ARRAY_LIST, intArrayListFull);
        task.printResults(intArrayListFull, cleaner);
        executionTimeReport.put(cleaner.getSolveBy(), cleaner.getExecutionTimeInNanoSec());

        // Case 2 - clean by add unique values in new LinkedList (iteration)
        cleaner = new ListCleanService<>(ADD_UNIQUE_VALUE_IN_NEW_LINKED_LIST, intLinkedListFull);
        task.printResults(intLinkedListFull, cleaner);
        executionTimeReport.put(cleaner.getSolveBy(), cleaner.getExecutionTimeInNanoSec());

        // Case 3 - clean by HashSet
        cleaner = new ListCleanService<>(ADD_ALL_LIST_IN_HASH_SET, intArrayListFull);
        task.printResults(intArrayListFull, cleaner);
        executionTimeReport.put(cleaner.getSolveBy(), cleaner.getExecutionTimeInNanoSec());

        // Case 4 - clean by LinkedHashSet
        cleaner = new ListCleanService<>(ADD_ALL_LIST_IN_LINKED_HASH_SET, intArrayListFull);
        task.printResults(intArrayListFull, cleaner);
        executionTimeReport.put(cleaner.getSolveBy(), cleaner.getExecutionTimeInNanoSec());

        // Case 5 - clean by TreeHashSet
        cleaner = new ListCleanService<>(ADD_ALL_LIST_IN_TREE_SET, intArrayListFull);
        task.printResults(intArrayListFull, cleaner);
        executionTimeReport.put(cleaner.getSolveBy(), cleaner.getExecutionTimeInNanoSec());

        // Case 6 - clean by using HashSet and Stream
        cleaner = new ListCleanService<>(USE_HASH_SET_AND_STREAM, intArrayListFull);
        task.printResults(intArrayListFull, cleaner);
        executionTimeReport.put(cleaner.getSolveBy(), cleaner.getExecutionTimeInNanoSec());

        // Case 7 - clean by using LinkedHashSet and Stream
        cleaner = new ListCleanService<>(USE_LINKED_HASH_SET_AND_STREAM, intArrayListFull);
        task.printResults(intArrayListFull, cleaner);
        executionTimeReport.put(cleaner.getSolveBy(), cleaner.getExecutionTimeInNanoSec());

        // Case 8 - clean by using TreeSet and Stream
        cleaner = new ListCleanService<>(USE_TREE_SET_AND_STREAM, intArrayListFull);
        task.printResults(intArrayListFull, cleaner);
        executionTimeReport.put(cleaner.getSolveBy(), cleaner.getExecutionTimeInNanoSec());

        // Print summary report
        task.printExecutionTimeReport(executionTimeReport);
    }

    private List<Integer> fillIntsList(List<Integer> list, int size, int valuesUpLimit){
        Random random = new Random();
        for(int i = 0; i < size; i++){
            list.add(random.nextInt(valuesUpLimit + 1));
        }
        return list;
    }

    private void printResults(List<?> initialArray, ListCleanService<?> cleaner){
        System.out.println("Solved by: " + cleaner.getSolveBy());
        System.out.println("Initial ArrayList: " + initialArray);
        System.out.println("ArrayList without duplicates: " + cleaner.getCleanedList());
        System.out.println("Number of duplicates: " + cleaner.getDuplicatesNumber());
        System.out.println("Duration = " + cleaner.getExecutionTimeInNanoSec() + " ns");
        System.out.println();
    }

    private void printExecutionTimeReport(Map<ListCleanService.SolveBy, Long> reportMap){
        System.out.println("Report (time in nanoseconds):");
        Map.Entry<ListCleanService.SolveBy, Long> fast = null;
        Map.Entry<ListCleanService.SolveBy, Long> slow = null;
        int count = 0;
        for (var entry : reportMap.entrySet()) {
            System.out.printf(entry.getKey()
                    + "%1$" + (50 - entry.getKey().toString().length()) + "s"
                    + entry.getValue()
                    + "\n", " ");
            if(count == 0){
                slow = fast = entry;
                count++;
            } else {
                long temp = entry.getValue();
                if(temp > slow.getValue()){
                    slow = entry;
                }else if(temp < fast.getValue()){
                    fast = entry;
                }
            }
        }
        System.out.println();
        assert fast != null;
        System.out.println("The best result:  " + fast.getKey() + "       " + fast.getValue() + " ns");
        System.out.println("The worst result: " + slow.getKey() + "      " + slow.getValue() + " ns");
    }
}
