package com.itcast.dao;

import com.itcast.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User,Long> {
    //注意SpringDataJPA默认会根据方法名自动生成sql:
    //select * from user where username = ? and password = ?
    User findByUsernameAndPassword(String username,String password);

    //上面的写法等价于下面的HQL写法(和SQL类似)
    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    User findBySQL(String username,String password);
}
