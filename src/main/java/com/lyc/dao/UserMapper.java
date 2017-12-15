package com.lyc.dao;

import com.lyc.model.po.Group;
import com.lyc.model.po.User;

import java.util.List;

/**
 * Created by lyc on 2017/12/15.
 * email 984006207@qq.com
 */
public interface UserMapper {

   List<User> findAll();

   List<User> findAll2();

   Group findGroupById(Group group);
}
