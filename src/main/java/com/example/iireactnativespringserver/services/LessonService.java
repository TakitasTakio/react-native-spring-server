package com.example.iireactnativespringserver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.iireactnativespringserver.models.Lesson;
import com.example.iireactnativespringserver.models.Module;
import com.example.iireactnativespringserver.repositories.ModuleRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonService {
	
	@Autowired
	ModuleRepository moduleRepository;
	@GetMapping("/api/module/{mid}/lesson")
	public List<Lesson> findLessonForModule(
	@PathVariable(name="mid") int moduleId) {
	Optional<Module> optionalModule =
	moduleRepository.findById(moduleId);
	if(optionalModule.isPresent()) {
	 Module module = optionalModule.get();
	 return (List<Lesson>) module.getLessons();
	}
	return null;
	}


}
