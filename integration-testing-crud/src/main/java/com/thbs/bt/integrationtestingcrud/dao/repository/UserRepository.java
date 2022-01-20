package com.thbs.bt.integrationtestingcrud.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thbs.bt.integrationtestingcrud.dao.entity.UserEntity;
import com.thbs.bt.integrationtestingcrud.service.dto.UserDto;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserDto> getById(long id);

}
