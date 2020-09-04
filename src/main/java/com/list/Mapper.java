package com.list;

public interface Mapper<T> {
  Object apply(T value);
}
