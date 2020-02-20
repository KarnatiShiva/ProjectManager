package com.fse.pm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fse.pm.entities.Project;

public interface IProjectRepository extends JpaRepository<Project, Integer>{

}
