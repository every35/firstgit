package day5.jdbc.service;

import day5.jdbc.dto.Users;

public interface UsersService {
	void insertAndupdate(Users user);
	String PassById(Users user);
	void insert(Users user);
}
