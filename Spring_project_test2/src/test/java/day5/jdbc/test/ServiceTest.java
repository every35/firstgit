package day5.jdbc.test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import day5.jdbc.dao.UsersDao;
import day5.jdbc.dto.Users;
import day5.jdbc.service.UsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbc-config.xml")
public class ServiceTest {
	private static Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	@Autowired
	UsersService service;
	@Autowired
	UsersDao dao;
	
	@Test
	public void testServiceBean(){
		logger.trace("service bean ok? {}",service);
		assertThat(service, is(not(nullValue())));
	}
	@Test
	public void testInsertAndUpdate(){
		Users user = new Users();
		user.setId("lol3");
		String name="롤2";
		user.setNickname(name);
		user.setPass("123");
		user.setEmail("every9168@naver.com");
		user.setAddress("서울");
		user.setMail_no("123-456");
		user.setCellphone("010-123");
		user.setRoll("null");
		service.insertAndupdate(user);
		Users retrieved = dao.selectUser(user.getId());
		assertThat(retrieved.getNickname(), is(not(name)));
		
	}
	@Test
	public void testPassById(){
		Users user = new Users();
		user.setId("lol6");
		user.setNickname("lol");
		user.setPass("123");
		user.setEmail("every9168@naver.com");
		user.setAddress("서울");
		user.setMail_no("123-456");
		user.setCellphone("010-123");
		user.setRoll("null");
		service.insert(user);
		service.PassById(user);
		String retrieved = dao.getUserPasswordById(user.getId());
		assertThat(retrieved, is("123"));
		
	}
	

}
