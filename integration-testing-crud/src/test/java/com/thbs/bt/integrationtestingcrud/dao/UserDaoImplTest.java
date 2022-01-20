package com.thbs.bt.integrationtestingcrud.dao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.thbs.bt.integrationtestingcrud.dao.entity.UserEntity;
import com.thbs.bt.integrationtestingcrud.dao.repository.UserRepository;
import com.thbs.bt.integrationtestingcrud.service.dto.UserDto;
import com.thbs.bt.integrationtestingcrud.translator.BaseTranslator;

class UserDaoImplTest {

	 @Mock
	    private UserRepository userRepository;
	    @Mock
	    private BaseTranslator<UserDto,UserEntity> userEntityTranslator;

	    @InjectMocks
	    private UserDaoImpl userDao;

	    @BeforeEach
	    public void setUp(){
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void createUser_whenUserDataIsValid_ReturnCreatedUserId(){
	        //Given
	        UserEntity userEntity = new UserEntity();
	        userEntity.setId(1L);

	        UserDto userDto = new UserDto();

	        when(userRepository.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);
	        when(userEntityTranslator.translate(Mockito.any(UserDto.class),eq(UserEntity.class))).thenReturn(userEntity);

	        //When
	        Long id = userDao.create(userDto);

	        //Then
	        assertNotNull(id);
	        verify(userRepository,times(1)).save(Mockito.any(UserEntity.class));
	        verify(userEntityTranslator,times(1)).translate(Mockito.any(UserDto.class),eq(UserEntity.class));
	    }

}
