package com.musical.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musical.project.Entity.Courses;


public interface CourseRepository extends JpaRepository<Courses,Integer> {
	

}
