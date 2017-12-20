package edu.eurasia.dao;

import java.util.List;

import edu.eurasia.entity.UsersBean;

public interface UserDao {
	
	// ¹ÜÀíÔ±µÇÂ¼
	List<UsersBean> login(UsersBean users) throws Exception;

}
