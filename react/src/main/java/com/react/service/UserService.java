package com.react.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.react.form.UserForm;
import com.react.model.User;
import com.react.util.RecordNotFoundException;

@Service
public interface UserService {
	public List<UserForm> getAllUsers();
	public UserForm getUserById(Long id) throws RecordNotFoundException;
	public User createOrUpdateUser(UserForm user) throws RecordNotFoundException;
	public void deleteUserById(Long id) throws RecordNotFoundException;
}
