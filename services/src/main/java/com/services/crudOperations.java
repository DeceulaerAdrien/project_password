package com.services;

public interface crudOperations<T> {
    void create(T obj);

    T read(int id);

    void update(T obj);

    void delete(int id);
}
