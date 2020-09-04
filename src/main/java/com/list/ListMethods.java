package com.list;

import java.util.Arrays;

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

  static public <T> T[] filter(T[] values, Predicate<T> predicate) {
    T[] filteredValues = values.clone();
    int currIndex = 0;
    for (T value : values) {
      if (predicate.apply(value)) {
        filteredValues[currIndex++] = value;
      }
    }
    return Arrays.copyOf(filteredValues, currIndex);
  }

  static public <T> Object[] map(T[] values, Mapper<T> mapper) {
    Object[] mappedValues = new Object[values.length];
    for (int index = 0; index < values.length; index++) {
      mappedValues[index] = mapper.apply(values[index]);
    }
    return mappedValues;
  }
}
