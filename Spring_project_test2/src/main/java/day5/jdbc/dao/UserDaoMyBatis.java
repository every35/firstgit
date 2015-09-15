package day5.jdbc.dao;

import day5.jdbc.dto.Users;

public interface UserDaoMyBatis {
	public Users getUsersById(String id);
}
