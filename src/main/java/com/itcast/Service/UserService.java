package com.itcast.Service;

import com.itcast.bean.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> findAll();

    User findOne(long id);

    User findByUsernameAndPassword(String username, String password);

    User findBySQL(String username, String password);
}
