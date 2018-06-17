package com.example.dao;

import com.example.entity.User;
import com.querydsl.core.types.Predicate;

public interface UserDao
{
    User createUser(User user);

    Iterable<User> queryUsers(Predicate predicate);
}
