package day5.jdbc.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import day5.jdbc.dao.UsersDao;
import day5.jdbc.dto.Board;
import day5.jdbc.dto.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbc-config.xml")
public class UsersDaoTest {
	private static Logger logger = LoggerFactory.getLogger(UsersDaoTest.class);
	
	@Autowired
	UsersDao dao;
	
	@Before
	public void cleanDB(){
		dao.deleteAllUsers();
	}
	
	@Test
	@Transactional
	public void getAllUsersCount() throws SQLException {
		int result = dao.getAllUsersCount();
		logger.trace("get all users cnt : {}",result);
		assertThat(result, is(1));
		
	}
	@Test
	@Transactional
	public void getUserPasswordById() throws SQLException {
		Users user = new Users();
		user.setPass("1234");
		user.setId("hong");
		user.setNickname("홍길동");
		user.setEmail("every35@nate.com");
		int result = dao.insertUser(user);
		String pass = dao.getUserPasswordById("hong");
		logger.trace("get user Id by pass : {}",pass);
		assertThat(pass, is("1234"));
		assertThat(result, is(1));
	}
	@Test
	@Transactional
	public void selectUserMap() {
		
		Map<String, Object> map=dao.getUserMapById("hong");
		logger.trace("user map : {}",map);
		assertThat(map.get("pass"), is("1234"));
	}
	@Test
	@Transactional
	public void selectUserList() {
		Users user = new Users();
		user.setPass("1234");
		user.setId("hong");
		user.setNickname("홍길동");
		user.setEmail("every35@nate.com");
		int result = dao.insertUser(user);
		
		List<Map<String, Object>> list=dao.getAllUsersMap();
		logger.trace("user list map : {}",list);
		assertThat(list.size(), is(dao.getAllUsersCount()));
		for(Map<String,Object> map:list){
			String userId = map.get("id").toString();
			assertThat(map.get("pass"), is(dao.getUserPasswordById(userId)));
		}
	}
	@Test
	@Transactional
	public void selectUserTest() {
		Users user = new Users();
		user.setPass("1234");
		user.setId("hong");
		user.setNickname("홍길동");
		user.setEmail("every9168@naver.com");
		int result = dao.insertUser(user);
		
		user = dao.selectUser("hong");
		assertThat(user.getPass(), is("1234"));
		assertThat(user.getNickname(), is("홍길동"));
		
	}
	@Test
	@Transactional
	public void getAllUserTest() {
		Users user = new Users();
		user.setPass("1234");
		user.setId("hong");
		user.setNickname("홍길동");
		user.setEmail("every35@naver.com");
		int result = dao.insertUser(user);
		
		List<Users> users = dao.getAllUsersList();
		assertThat(users.size(), is(dao.getAllUsersCount()));
		for(Users data:users){
			String userId=data.getId();
			assertThat(data.getPass(), is(dao.getUserPasswordById(userId)));
		}
	}
	@Test
	@Transactional
	public void selectFullUserTest() {
		/*Users user = new Users();
		user.setPassword("1234");
		user.setUserId("hong");
		user.setUserName("홍길동");
		int result = dao.insertUser(user);
		
		user = dao.selectFullUser("hong");
		assertThat(user.getPassword(), is(dao.getUserPasswordById("hong")));
		List<Board> boards = user.getBoards();
		logger.trace("board : {}",boards);
		assertThat(boards.size(), is(1));*/
	}
	@Test
	@Transactional
	public void addTest() {
		Users user = new Users();
		user.setPass("1234");
		user.setId("hong");
		user.setNickname("홍길동");
		user.setEmail("every9168@naver.com");
		user.setCellphone("010-7747-9168");
		user.setAddress("충남 천안");
		user.setMail_no("330-210");
		user.setRoll("관리자");
		int result = dao.insertUser(user);
		assertThat(result, is(1));
		Users retrieved = dao.selectUser("hong");
		assertThat(retrieved.getNickname(), is(user.getNickname()));
		
	}	
	@Test
	@Transactional
	public void updateTest() {
		Users user = new Users();
		
		user.setId("hong");
		String orgname="홍서범";
		user.setNickname(orgname);
		user.setPass("1234");
		user.setEmail("every9168@naver.com");
		dao.insertUser(user);
		
		user.setNickname("홍길동");
		
		int result = dao.updateUser(user);
		assertThat(result, is(1));
		Users retrieved = dao.selectUser("hong");
		assertThat(retrieved.getNickname(), is(user.getNickname()));
		assertThat(retrieved.getId(), is(not(orgname)));
		
	}
	@Test
	@Transactional
	public void deleteTest() {
		Users user = new Users();
		user.setPass("1234");
		user.setId("hong");
		user.setNickname("홍길동");
		user.setEmail("every9168@naver.com");
		int result = dao.insertUser(user);
		assertThat(result, is(1));
		result = dao.deleteUser("hong");
		assertThat(result, is(1));
		result = dao.insertUser(user);
		assertThat(result, is(1));
		
	}

}
