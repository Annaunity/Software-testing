package com.lab1.secondTask;

import java.util.*;

public class CloseHash {
    private int capacity;
    private List<LinkedList<Integer>> table;

    public CloseHash(int capacity) {
        this.capacity = capacity;
        table = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<>());
        }
    }


    public void add(int n) {
        var h = hash(n);
        table.get(h).addLast(n);
    }

    public boolean delete(int n) {
        var h = hash(n);
        var bucket = table.get(h);
        if (bucket.isEmpty()) {
            return false;
        }

        ListIterator<Integer> it = bucket.listIterator(bucket.size());

        while (it.hasPrevious()) {
            if (it.previous() == n) {
                it.remove();
                return true;
            }
        }

        return false;
    }

    public boolean contains(int n) {
        var h = hash(n);
        var bucket = table.get(h);
        if (bucket.isEmpty()) {
            return false;
        }

        ListIterator<Integer> it = bucket.listIterator(bucket.size());

        while (it.hasPrevious()) {
            if (it.previous() == n) {
                return true;
            }
        }

        return false;
    }

    private int hash(int n) {
        return Math.abs(n % capacity);
    }
}
