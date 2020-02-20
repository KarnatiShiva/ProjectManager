package com.fse.pm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.pm.entities.Users;

public interface IUserRepository extends JpaRepository<Users, Integer>{

}
