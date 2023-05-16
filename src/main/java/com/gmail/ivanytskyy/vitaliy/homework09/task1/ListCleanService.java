package com.gmail.ivanytskyy.vitaliy.homework09.task1;

import java.util.*;

/**
 * @author Vitaliy Ivanytskyy
 * @version 1.00
 * @date 13/05/2023
 */
public class ListCleanService<T extends Comparable<T>>{
    private int duplicatesNumber;
    private final long executionTimeInNanoSec;
    private List<T> cleanedList;
    private final SolveBy solveBy;

    public ListCleanService(SolveBy solveBy, List<T> list){
        if(solveBy == null || list == null)
            throw new IllegalArgumentException("Incorrect input values");
        this.solveBy = solveBy;
        long start = System.nanoTime();
        switch (solveBy) {
            case ADD_UNIQUE_VALUE_IN_NEW_ARRAY_LIST -> {
                this.cleanedList = new ArrayList<>();
                cleanByAddToNewList(list);
            }
            case ADD_UNIQUE_VALUE_IN_NEW_LINKED_LIST -> {
                this.cleanedList = new LinkedList<>();
                cleanByAddToNewList(list);
            }
            case ADD_ALL_LIST_IN_HASH_SET -> cleanBySet(list, new HashSet<>());
            case ADD_ALL_LIST_IN_LINKED_HASH_SET -> cleanBySet(list, new LinkedHashSet<>());
            case ADD_ALL_LIST_IN_TREE_SET -> cleanBySet(list, new TreeSet<>());
            case USE_HASH_SET_AND_STREAM -> cleanBySetAndStream(list, HashSet::new);
            case USE_LINKED_HASH_SET_AND_STREAM -> cleanBySetAndStream(list, LinkedHashSet::new);
            case USE_TREE_SET_AND_STREAM -> cleanBySetAndStream(list, TreeSet::new);
        }
        long finish = System.nanoTime();
        this.executionTimeInNanoSec = finish - start;
    }

    private void cleanByAddToNewList(List<T> list){
        for (T value : list) {
            if(!this.cleanedList.contains(value)) {
                this.cleanedList.add(value);
            }else {
                this.duplicatesNumber++;
            }
        }
    }

    private void cleanBySet(List<T> list, Set<T> set){
        set.addAll(list);
        this.cleanedList = new ArrayList<>(set);
        this.duplicatesNumber = list.size() - this.cleanedList.size();
    }

    private void cleanBySetAndStream(List<T> list, SupplierFunc<T> supplyConstructor){
        this.cleanedList = supplyConstructor.get(list).stream().toList();
        this.duplicatesNumber = list.size() - this.cleanedList.size();
    }

    public int getDuplicatesNumber() {
        return duplicatesNumber;
    }

    public long getExecutionTimeInNanoSec() {
        return executionTimeInNanoSec;
    }

    public List<T> getCleanedList() {
        return cleanedList;
    }

    public SolveBy getSolveBy() {
        return solveBy;
    }

    public enum SolveBy {
        ADD_UNIQUE_VALUE_IN_NEW_ARRAY_LIST,
        ADD_UNIQUE_VALUE_IN_NEW_LINKED_LIST,
        ADD_ALL_LIST_IN_HASH_SET,
        ADD_ALL_LIST_IN_LINKED_HASH_SET,
        ADD_ALL_LIST_IN_TREE_SET,
        USE_HASH_SET_AND_STREAM,
        USE_LINKED_HASH_SET_AND_STREAM,
        USE_TREE_SET_AND_STREAM
    }

    @FunctionalInterface
    private interface SupplierFunc <T extends Comparable<T>> {
        Set<T> get(List<T> list);
    }
}