package day5.jdbc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import day5.jdbc.dao.UsersDao;
import day5.jdbc.dto.Users;

@Service
public class UserServiceImpl implements UsersService {
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UsersDao dao;

	@Override
	@Transactional
	public void insertAndupdate(Users user) {
		int insertResult = dao.insertUser(user);
		logger.trace("insert over : {}", insertResult);
		user.setNickname((int) (Math.random()) * 10000 + "");
		int updateResult = dao.updateUser(user);
		logger.trace("update over : {}", updateResult);
	}

	@Override
	public String PassById(Users user) {
		String selectResult = dao.getUserPasswordById(user.getId());
		logger.trace("select over : {}", selectResult);
		if (selectResult == user.getId()) {
			return "0";
		} else {
			return "1";
		}
	}

	@Override
	public void insert(Users user) {
		int insertResult = dao.insertUser(user);
		logger.trace("insert over : {}",insertResult);
		
	}

}
