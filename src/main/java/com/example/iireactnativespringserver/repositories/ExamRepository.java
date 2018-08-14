package com.example.iireactnativespringserver.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.iireactnativespringserver.models.Exam;



public interface ExamRepository extends CrudRepository <Exam, Integer> {

}
