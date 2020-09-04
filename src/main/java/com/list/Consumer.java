package com.list;

public interface Consumer<T> {
  void apply(T value);
}
