package com.app.UserBookAppl.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.UserBookAppl.model.user.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

}
