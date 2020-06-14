package com.company;

import java.util.*;

//HashSetImplication
public class HashSetImp {
    private final double loadFactor = 0.75;
    private int size = 0;

    private HashEntry[] table = new HashEntry[8];

    HashSetImp() {
    }

    public int size() {
        return size;
    }

    public Object get(Object key) {
        int index = (table.length - 1) & key.hashCode();
        while (table[index] != null && !table[index].getKey().equals(key)) {
            index = (index + 1) % table.length;
        }
        if (table[index] == null)
            return null;
        else
            return table[index].getValue();
    }

    private int getIndex(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0) {
            index += table.length;
        }
        return index;
    }

    private HashEntry getEntry(Object key, int index) {
        if (index < 0) {
            index = getIndex(key);
        }
        for (HashEntry curr = table[index]; curr != null; curr = curr.next) {
            if (key.equals(curr.key)) {
                return curr;
            }
        }
        return null;
    }

    public void put(Object key, Object value) {
        int index = (table.length - 1) & key.hashCode();
        int threshold = (int) (table.length * loadFactor);
        if (threshold <= size) {
            HashEntry[] newTable;
            int newSize = table.length * 2;
            newTable = new HashEntry[newSize];
            for (HashEntry hashEntry : table)
                if (hashEntry != null) {
                    int newHash = (newSize - 1) & hashEntry.getKey().hashCode();
                    while (newTable[newHash] != null && !newTable[newHash].getKey().equals(hashEntry.getKey())) {
                        newHash = (newHash + 1) % newSize;
                    }
                    newTable[newHash] = new HashEntry(hashEntry.getKey(), hashEntry.getValue());
                }
            table = Arrays.copyOf(newTable, newSize);
        }
        while (table[index] != null && !table[index].getKey().equals(key)) {
            index = (index + 1) % table.length;
        }
        table[index] = new HashEntry(key, value);
        size++;
    }

    public void remove(Object key) {
        int index = (table.length - 1) & key.hashCode();
        if (table[index] != null && table[index].getKey().equals(key)) {
            table[index] = null;
        }
    }

    public String toString() {
        return Arrays.toString(table);
    }

    public boolean containsKey(Object key) {
        return getEntry(key, -1) != null;
    }

    public boolean containsValue(Object value) {
        return entrySet().stream().anyMatch(kv -> value.equals(kv.getValue()));
    }

    //единственный вызвавший затруднения метод, который был взят у Д. И.
    public Set<HashEntry> entrySet() {
        return new DefaultNotSupportedSet<>() {

            public int size() {
                return HashSetImp.this.size();
            }

            public Iterator<HashEntry> iterator() {
                return new Iterator<>() {
                    int tableIndex = -1;
                    HashEntry curr = null;
                    {
                        findNext();
                    }

                    private void findNext() {
                        if (tableIndex >= table.length) {
                            return;
                        }
                        if (curr != null) {
                            curr = curr.next;
                        }
                        if (curr == null) {
                            for (tableIndex = tableIndex + 1; tableIndex < table.length; tableIndex++) {
                                curr = table[tableIndex];
                                if (curr != null) {
                                    break;
                                }
                            }
                        }
                    }

                    public boolean hasNext() {
                        return curr != null;
                    }

                    public HashEntry next() {
                        HashEntry temp = curr;
                        findNext();
                        return temp;
                    }
                };
            }
        };
    }
}