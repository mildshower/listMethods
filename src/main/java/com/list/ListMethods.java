package com.list;

public class ListMethods {
    static public <T> void forEach(T[] values, Consumer<T> action) {
        for (T value : values) {
            action.apply(value);
        }
    }

    static public <T, U> U reduce(T[] values, Reducer<T, U> reducer, U initialContext) {
        U context = initialContext;
        for (T value : values) {
            context = reducer.apply(context, value);
        }
        return context;
    }
}
