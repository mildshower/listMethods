package com.list;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
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

  static public <T, U> U[] map(T[] values, Mapper<T, U> mapper, U[] typeArray) {
    ArrayList<U> mappedValues = new ArrayList<>(values.length);
    for (T value : values) {
      mappedValues.add(mapper.apply(value));
    }
    return mappedValues.toArray(typeArray);
  }
}
