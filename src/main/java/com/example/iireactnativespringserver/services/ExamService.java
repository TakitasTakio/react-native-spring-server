package com.example.iireactnativespringserver.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.iireactnativespringserver.models.Exam;
import com.example.iireactnativespringserver.models.Lesson;

import com.example.iireactnativespringserver.repositories.LessonRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExamService {
	
	@Autowired
	LessonRepository lessonRepository;
	@GetMapping("/api/lesson/{lid}/exam")
	public List<Exam> findExamForLesson(
	@PathVariable(name="lid") int lessonId) {
	Optional<Lesson> optionalLesson =
	lessonRepository.findById(lessonId);
	if(optionalLesson.isPresent()) {
	 Lesson lesson = optionalLesson.get();
	 return (List<Exam>) lesson.getExams();
	}
	return null;
	}

}
