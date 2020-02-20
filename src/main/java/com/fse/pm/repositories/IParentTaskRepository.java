package com.fse.pm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.pm.entities.ParentTask;

public interface IParentTaskRepository extends JpaRepository<ParentTask, Integer>{

}
