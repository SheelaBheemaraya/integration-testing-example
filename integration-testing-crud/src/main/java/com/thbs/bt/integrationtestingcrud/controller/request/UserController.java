package com.thbs.bt.integrationtestingcrud.controller.request;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thbs.bt.integrationtestingcrud.controller.response.UserResponse;
import com.thbs.bt.integrationtestingcrud.exeception.UserNotFoundException;
import com.thbs.bt.integrationtestingcrud.service.UserService;
import com.thbs.bt.integrationtestingcrud.service.dto.UserDto;
import com.thbs.bt.integrationtestingcrud.translator.BaseTranslator;

@RequestMapping("/users/")
public class UserController {
	private UserService userService;
	private BaseTranslator<CreateEmployeeRequest, UserDto> createUserRequestToUserDtoTranslator;
	private BaseTranslator<UserDto, UserResponse> userDtoToUserResponseTranslator;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public BaseTranslator<CreateEmployeeRequest, UserDto> getCreateUserRequestToUserDtoTranslator() {
		return createUserRequestToUserDtoTranslator;
	}
	public void setCreateUserRequestToUserDtoTranslator(
			BaseTranslator<CreateEmployeeRequest, UserDto> createUserRequestToUserDtoTranslator) {
		this.createUserRequestToUserDtoTranslator = createUserRequestToUserDtoTranslator;
	}
	public BaseTranslator<UserDto, UserResponse> getUserDtoToUserResponseTranslator() {
		return userDtoToUserResponseTranslator;
	}
	public void setUserDtoToUserResponseTranslator(BaseTranslator<UserDto, UserResponse> userDtoToUserResponseTranslator) {
		this.userDtoToUserResponseTranslator = userDtoToUserResponseTranslator;
	}
	 @GetMapping
	    public ResponseEntity<List<UserResponse>> findAllUsers(){
	        return new ResponseEntity(userDtoToUserResponseTranslator.translate(userService.findAll(),UserResponse.class), HttpStatus.OK);
	    }
	    @PostMapping
	    public ResponseEntity<Object> create(@RequestBody @Valid CreateEmployeeRequest user){
	        return new ResponseEntity(userService.create(createUserRequestToUserDtoTranslator.translate(user,UserDto.class)), HttpStatus.OK);
	    }
	    @GetMapping("{id}")
	    public ResponseEntity<Object> findById(@PathVariable("id") long userId){
	       return userService.findById(userId)
	               .map(user->new ResponseEntity(user,HttpStatus.OK))
	               .orElseThrow(()->new UserNotFoundException("User not found"));
	    }
}
