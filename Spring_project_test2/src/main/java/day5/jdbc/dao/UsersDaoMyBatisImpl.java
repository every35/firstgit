package day5.jdbc.dao;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import day5.jdbc.dto.Users;
@Repository
public class UsersDaoMyBatisImpl implements UserDaoMyBatis {
	private String nameSpace = "mybatis.dao.UsersMapper";
	@Autowired
	SqlSessionTemplate session;
	@Override
	public Users getUsersById(String id) {
		String stmt = nameSpace+"selectUser";		
		return session.selectOne(stmt,id);
	}
	
	

}
