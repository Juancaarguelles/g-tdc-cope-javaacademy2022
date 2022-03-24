package com.thesis.services;

import java.util.List;

public interface ModelService <T>
{
    List<T> findAll();

    T getById(Integer id);

    T save(T t);

    void delete(Integer id);
}