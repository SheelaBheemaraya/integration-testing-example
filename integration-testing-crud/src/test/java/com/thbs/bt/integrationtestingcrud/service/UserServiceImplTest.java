package com.thbs.bt.integrationtestingcrud.service;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.thbs.bt.integrationtestingcrud.dao.UserDao;
import com.thbs.bt.integrationtestingcrud.dto.User;
import com.thbs.bt.integrationtestingcrud.service.dto.UserDto;
import com.thbs.bt.integrationtestingcrud.translator.BaseTranslator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
class UserServiceImplTest {

	 @Mock
	    private UserDao userDao;
	    @Mock
	    private BaseTranslator<User,UserDto> userDtoTranslator;

	    @InjectMocks
	    private UserServiceImpl userService;

	    @BeforeEach
	    public void setUp(){
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void findAll_WhenRecordPresent_ReturnList(){
	        //Given
	        when(userDao.findAll()).thenReturn(Arrays.asList(new UserDto()));
	        //When
	        List<UserDto> userDtoList= userService.findAll();

	        //Then
	        assertFalse(userDtoList.isEmpty());
	        verify(userDao,times(1)).findAll();
	    }

}
