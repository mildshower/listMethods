package com.list;

public interface Predicate<T> {
  Boolean apply(T value);
}
