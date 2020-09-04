package com.list;

public class ListMethods {
    static public <T> void forEach(T[] values, Consumer<T> action) {
        for (T value : values) {
            action.apply(value);
        }
    }
}
