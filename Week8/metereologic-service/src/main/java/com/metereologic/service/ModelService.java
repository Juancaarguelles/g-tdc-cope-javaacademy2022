package com.metereologic.service;

import java.util.List;

public interface ModelService<T>
{
    List<T>listAll();
    T getById(Integer id);
    void save(T t);
    void delete(Integer id);
}
