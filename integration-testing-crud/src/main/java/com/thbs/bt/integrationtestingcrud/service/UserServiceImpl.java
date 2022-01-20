package com.thbs.bt.integrationtestingcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.thbs.bt.integrationtestingcrud.dao.UserDao;
import com.thbs.bt.integrationtestingcrud.dto.User;
import com.thbs.bt.integrationtestingcrud.service.dto.UserDto;
import com.thbs.bt.integrationtestingcrud.translator.BaseTranslator;

@Service
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private BaseTranslator<User, UserDto> userDtoTranslator;
	

	public UserServiceImpl(UserDao userDao, BaseTranslator<User, UserDto> userDtoTranslator) {
		super();
		this.userDao = userDao;
		this.userDtoTranslator = userDtoTranslator;
	}

	@Override
	public List<UserDto> findAll() {
		return userDao.findAll();
	}

	@Override
	public long create(UserDto user) {
		return userDao.create(user);
	}

	@Override
	public Optional<UserDto> findById(long userId) {
		return userDao.findById(userId);
	}
}