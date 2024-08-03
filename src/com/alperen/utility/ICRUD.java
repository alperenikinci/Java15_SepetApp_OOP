package com.alperen.utility;


import com.alperen.entities.BaseEntity;

import java.util.List;

public interface ICRUD<T> {
    T save(T t);
    List<T> saveAll(List<T> t);
    T update(T t);
    List<T> findAll();
    T findByID(int id);
}
