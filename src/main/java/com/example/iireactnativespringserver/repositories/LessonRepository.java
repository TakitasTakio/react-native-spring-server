package com.example.iireactnativespringserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.iireactnativespringserver.models.Lesson;

public interface LessonRepository extends CrudRepository <Lesson, Integer> {

}
