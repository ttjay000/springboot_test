package com.itcast.controller;

import com.itcast.Service.UserService;
import com.itcast.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String hello(String name) {
        return name + ",hello";
    }

    //新增用户
    //post
    //localhost:8081/user/add
    //username=jack
    //password=888
    //nickname=jackma
    //post
    //localhost:8081/user/add
    //username=andy
    //password=666
    //nickname=andyliu
    @GetMapping("add")
    public String addUser(User user) {
        userService.add(user);
        return "add user success";
    }

    //查询所有
    @GetMapping("findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    //查询单个
    @GetMapping("find/{id}")
    public User findOne(@PathVariable long id) {
        return userService.findOne(id);
    }

    //按条件查询
//4.带条件查询
//get
//localhost:8081/user/findByUsernameAndPassword/jack/888
    @GetMapping("findByUsernameAndPassword/{username}/{password}")
    public User findByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        return userService.findByUsernameAndPassword(username, password);
    }

    @GetMapping("findBySQL/{username}/{password}")
    public User findBySQL(@PathVariable String username, @PathVariable String password) {
        return userService.findBySQL(username, password);
    }

}
