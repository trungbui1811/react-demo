package com.react.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.react.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

}
