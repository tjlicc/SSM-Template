package com.example.service.inter;

import java.util.List;

import com.example.model.User;

public interface UserService {

	List<User> getAll();
	
	User selectByPrimaryKey(String id);
	
    int insert(User muser);
    
    int update(User muser);
    
    int delete(String id);
}
