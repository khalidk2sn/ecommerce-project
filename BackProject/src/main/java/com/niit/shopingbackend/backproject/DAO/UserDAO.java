package com.niit.shopingbackend.backproject.DAO;

import java.util.List;

import com.niit.shopingbackend.backproject.model.User;

public interface UserDAO {

	boolean addUser(User u);
	List<User>getAllUser();
}
