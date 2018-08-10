package com.lyc.dao;

import com.lyc.model.po.Dept;
import com.lyc.model.po.Group;
import com.lyc.model.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lyc on 2017/12/15.
 * email 984006207@qq.com
 */
public interface UserMapper {

   List<User> findAll();

   List<User> findAll2();

   Group findGroupById(Group group);

   Dept dept1(@Param("id") int id);
}
