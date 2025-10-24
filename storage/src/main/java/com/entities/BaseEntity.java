package com.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class BaseEntity<T extends Serializable> {

    private T id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public BaseEntity(T id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {

        createdAt = LocalDateTime.now();
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        updatedAt = LocalDateTime.now();
        this.updatedAt = updatedAt;
    }
}
