package com.example.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public interface UserDao {
	
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> getAll();
}