package org.litbear.ssm.dao;

import org.litbear.ssm.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by litbear on 2017/7/4.
 */
@Repository
public interface UserDao {
    public List<User> getAllUsers();

    public Integer insertUser(User user);

    public Integer updateUser(User user);
}
