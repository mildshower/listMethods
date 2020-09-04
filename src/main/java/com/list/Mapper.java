package com.list;

public interface Mapper<T, U> {
  U apply(T value);
}
