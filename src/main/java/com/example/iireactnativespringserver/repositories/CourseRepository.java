package com.example.iireactnativespringserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.iireactnativespringserver.models.Course;

public interface CourseRepository extends CrudRepository<Course, Integer>
{

}
