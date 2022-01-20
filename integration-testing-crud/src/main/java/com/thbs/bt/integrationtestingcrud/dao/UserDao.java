package com.thbs.bt.integrationtestingcrud.dao;

import java.util.List;
import java.util.Optional;

import com.thbs.bt.integrationtestingcrud.service.dto.UserDto;

public interface UserDao {
	 List<UserDto> findAll();
	    long create(UserDto userDto);
	    Optional<UserDto> findById(long userId);
}
