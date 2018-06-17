package com.example.dao;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(final User user)
    {
        return this.userRepository.save(user);
    }

    @Override
    public Iterable<User> queryUsers(final Predicate predicate)
    {
        return this.userRepository.findAll(predicate);
    }
}
