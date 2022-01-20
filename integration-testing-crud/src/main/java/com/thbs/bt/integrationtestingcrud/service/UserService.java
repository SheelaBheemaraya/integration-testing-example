package com.thbs.bt.integrationtestingcrud.service;

import java.util.List;
import java.util.Optional;

import com.thbs.bt.integrationtestingcrud.service.dto.UserDto;

public interface UserService {
	List<UserDto> findAll();
    long create(UserDto user);

    Optional<UserDto> findById(long userId);

}
