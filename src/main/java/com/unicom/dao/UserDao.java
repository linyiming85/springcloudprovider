package com.unicom.dao;

import com.unicom.entity.User;

import java.util.List;

/**
 * Created by linym on 2017/12/10.
 */
public interface UserDao {

    int insert(User user);
    List<User> list(User user);
}
