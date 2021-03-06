package com.company.interfaces;

import com.company.exceptions.PasswordException;

@FunctionalInterface
public interface IPasswordChecker <T, V, U>
{
    U apply(T t, V v) throws PasswordException;
}
