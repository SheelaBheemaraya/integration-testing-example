package com.thbs.bt.integrationtestingcrud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.thbs.bt.integrationtestingcrud.dao.entity.UserEntity;
import com.thbs.bt.integrationtestingcrud.dao.repository.UserRepository;
import com.thbs.bt.integrationtestingcrud.service.dto.UserDto;
import com.thbs.bt.integrationtestingcrud.translator.BaseTranslator;

@Repository
public class UserDaoImpl implements UserDao {
	private UserRepository userRepository;
	private BaseTranslator<UserDto, UserEntity> userEntityTranslator;

	public UserDaoImpl(UserRepository userRepository, BaseTranslator<UserDto, UserEntity> userEntityTranslator) {
		super();
		this.userRepository = userRepository;
		this.userEntityTranslator = userEntityTranslator;
	}

	@Override
	public List<UserDto> findAll() {
		return null;
	}

	@Override
	public long create(UserDto userDto) {
		return userRepository.save(userEntityTranslator.translate(userDto, UserEntity.class)).getId();}

	@Override
	public Optional<UserDto> findById(long userId) {
		// TODO Auto-generated method stub
		return userRepository.getById(userId);
	}

}
