package com.alperen.entities;

import java.time.LocalDate;

public class BaseEntity {
    protected int id;
    private LocalDate createDate;

    public BaseEntity() {
        this.createDate = LocalDate.now();
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public int getId() {
        return id;
    }

}
