package com.list;

import java.lang.reflect.Array;
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
    @SuppressWarnings("unchecked")
    T[] filteredValues1 = (T[]) Array.newInstance(values.getClass().getComponentType(), values.length);
    int currIndex = 0;
    for (T value : values) {
      if (predicate.apply(value)) {
        filteredValues1[currIndex++] = value;
      }
    }
    return Arrays.copyOf(filteredValues1, currIndex);
  }

  static public <T, U> U[] map(T[] values, Mapper<T, U> mapper, Class<U> returnListType) {
    @SuppressWarnings("unchecked")
    U[] mappedList = (U[]) Array.newInstance(returnListType, values.length);
    for (int index = 0; index < values.length; index++) {
      mappedList[index] = mapper.apply(values[index]);
    }
    return mappedList;
  }
}
