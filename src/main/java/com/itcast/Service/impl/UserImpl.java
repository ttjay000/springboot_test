package com.itcast.Service.impl;

import com.itcast.Service.UserService;
import com.itcast.bean.User;
import com.itcast.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(long id) {
        return userDao.getOne(id);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findBySQL(String username, String password) {
        return userDao.findBySQL(username, password);
    }
}
