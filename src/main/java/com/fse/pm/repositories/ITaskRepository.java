package com.fse.pm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.pm.entities.Task;

public interface ITaskRepository extends JpaRepository<Task, Integer>{

}
