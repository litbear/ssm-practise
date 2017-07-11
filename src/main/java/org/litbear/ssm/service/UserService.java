package org.litbear.ssm.service;

import org.litbear.ssm.dao.UserDao;
import org.litbear.ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by litbear on 2017/7/11.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
