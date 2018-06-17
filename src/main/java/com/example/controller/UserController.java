package com.example.controller;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class UserController
{
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public User createUser(@RequestBody final User user)
    {
        return this.userDao.createUser(user);
    }

    @RequestMapping(path = "/user/query", method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    public Iterable<User> queryUser(@QuerydslPredicate(root = User.class) final Predicate predicate)
    {
        return this.userDao.queryUsers(predicate);
    }
}
