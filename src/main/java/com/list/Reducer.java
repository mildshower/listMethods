package com.list;

public interface Reducer<T, U> {
  U apply(U context, T currValue);
}
