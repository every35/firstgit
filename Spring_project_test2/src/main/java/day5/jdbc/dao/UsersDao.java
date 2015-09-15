package day5.jdbc.dao;

import java.util.List;
import java.util.Map;

import day5.jdbc.dto.Users;

public interface UsersDao {
	public int getAllUsersCount();
	public String getUserPasswordById(String id);
	public Map<String,Object> getUserMapById(String id);
	public List<Map<String,Object>> getAllUsersMap();
	public Users selectUser(String id);
	public List<Users> getAllUsersList();
	public Users selectFullUser(String id);
	public int insertUser(Users user);
	public int updateUser(Users user);
	public int deleteUser(String id);
	public int deleteAllUsers();
	
}
