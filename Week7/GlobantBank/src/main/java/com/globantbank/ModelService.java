package com.globantbank;

import java.util.List;

public interface ModelService <T>
{
    public List<T> listAll();
    public T getById(Integer id);
    public void save(T t);
    public void delete(Integer id);
}
