package com.react.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.react.dao.UserDao;
import com.react.form.UserForm;
import com.react.model.User;
import com.react.service.UserService;
import com.react.util.RecordNotFoundException;

public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	@Override
	public List<UserForm> getAllUsers() {
		List<User> lstUser = userDao.findAll();
		List<UserForm> lstResult = new ArrayList<>();
		if(lstUser.size() > 0) {
			for(User u:lstUser) {
				lstResult.add(modelToForm(u));
			}
			return lstResult;
		}
		return new ArrayList<>();
	}

	@Override
	public UserForm getUserById(Long id) throws RecordNotFoundException {
		Optional<User> user = userDao.findById(id);
		if(user.isPresent()) {
			return modelToForm(user.get());
		}
		throw new RecordNotFoundException("No exist user");
	}

	@Override
	public User createOrUpdateUser(UserForm user) throws RecordNotFoundException {
		Optional<User> entity = userDao.findById(user.getUserId());
		User u;
		if(entity.isPresent()) {
			u = entity.get();
			formToModel(user, u);
		}else {
			u = new User();
			formToModel(user, u);
			u.setUserName(user.getUserName());
		}
		u = userDao.save(u);
		return u;
	}

	@Override
	public void deleteUserById(Long id) throws RecordNotFoundException {
		Optional<User> entity = userDao.findById(id);
		if(entity.isPresent()) {
			userDao.deleteById(id);
		}
		throw new RecordNotFoundException("No exist user");
	}
	
	private UserForm modelToForm(User user) {
		UserForm result = new UserForm();
		result.setUserId(user.getUserId());
		result.setUserName(user.getUserName());
		result.setFullName(user.getFullName());
		result.setCellphone(user.getCellphone());
		result.setEmail(user.getEmail());
		return result;
	}
	
	private void formToModel(UserForm user, User u) {
		u.setFullName(user.getFullName());
		u.setCellphone(user.getCellphone());
		u.setEmail(user.getEmail());
	}
	
}
