package day5.jdbc.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import day5.jdbc.dao.UserDaoMyBatis;
import day5.jdbc.dao.UsersDao;
import day5.jdbc.dto.Users;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbc-config.xml")
public class UsersDaoMyBatisTest {

	@Autowired
	UserDaoMyBatis dao;
	@Autowired
	UsersDao jdbcDao;
	
	@Before
	public void initDb(){
		jdbcDao.deleteAllUsers();
		Users users = new Users();
		users.setId("hong");
		users.setNickname("홍길동");
		users.setPass("1234");
		jdbcDao.insertUser(users);
	}
	@Test
	@Transactional
	public void selectUsersTest() {
		Users selected = dao.getUsersById("hong");
		assertThat(selected.getNickname(), is("홍길동"));
	}

}
