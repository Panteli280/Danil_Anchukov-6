package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

interface DefaultNotSupportedSet<T> extends Set<T> {

    default int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default boolean add(T e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    default void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}