package day5.jdbc.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import day5.jdbc.dao.UsersDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/jdbc-config.xml")
public class DataSourceTest {
private static Logger logger = LoggerFactory.getLogger(DataSourceTest.class);
	@Autowired
	DataSource ds;
	@Autowired
	JdbcTemplate jt;
	@Autowired
	NamedParameterJdbcTemplate namedjt;
	@Autowired
	UsersDao dao;
	@Test
	public void testDataSourceInit() {
		logger.trace("dataSource : {}",ds);
		assertThat(ds, is(not(nullValue())));
		try{
			Connection con =ds.getConnection();
			logger.trace("connection : {}",con);
			assertThat(con, is(not(nullValue())));
		}catch(SQLException e){
			logger.trace("ds 초기화 테스트 실패 ",e);
		}
	}
	@Test
	public void testJdbcTemplateBean() {
		logger.trace("Jdbc Template : {}",jt);
		assertThat(jt, is(not(nullValue())));
	}
	@Test
	public void testNamedJdbcTemplateBean() {
		logger.trace("Named Jdbc Template : {}",namedjt);
		assertThat(namedjt, is(not(nullValue())));
	}
	@Test
	public void testUsersDaoBean() {
		logger.trace("UsersDao : {}",dao);
		assertThat(dao, is(not(nullValue())));
	}

}
