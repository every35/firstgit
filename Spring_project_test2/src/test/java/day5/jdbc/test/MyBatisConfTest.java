package day5.jdbc.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbc-config.xml")
public class MyBatisConfTest {

	@Autowired
	SqlSessionFactoryBean factory;
	@Autowired
	SqlSessionTemplate session;
	
	@Test
	public void getBeanTest(){
		assertThat(factory, is(notNullValue()));
		assertThat(session, is(notNullValue()));
	}

}
