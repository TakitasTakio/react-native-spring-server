package com.example.iireactnativespringserver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.iireactnativespringserver.models.Course;
import com.example.iireactnativespringserver.models.Module;
import com.example.iireactnativespringserver.repositories.CourseRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ModuleService {
	
	@Autowired
	CourseRepository courseRepository;
	@GetMapping("/api/course/{courseId}/module")
	public List<Module> findAllModulesForCourse(
	 @PathVariable("courseId") int courseId) {
	Optional<Course> data = courseRepository.findById(courseId);
	if(data.isPresent()) {
	Course course = data.get();
	return course.getModules();
	}
	return null; 
	}

}
