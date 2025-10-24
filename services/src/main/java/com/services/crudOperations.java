package com.services;

public interface crudOperations<ID, T> {
    void create(T obj);

    T read(ID id);

    void update(T obj);

    void delete(ID id);
}
