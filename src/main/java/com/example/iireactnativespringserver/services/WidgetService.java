package com.example.iireactnativespringserver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.iireactnativespringserver.models.Lesson;
import com.example.iireactnativespringserver.models.Widget;
import com.example.iireactnativespringserver.repositories.LessonRepository;
import com.example.iireactnativespringserver.repositories.WidgetRepository;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)


public class WidgetService {
	
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	WidgetRepository widgetRepository;
	
	@GetMapping("/api/lesson/{lid}/assignment")
	public List<Widget> findWidgetForLesson(
	@PathVariable(name="lid") int lessonId) {
	Optional<Lesson> optionalLesson =
	lessonRepository.findById(lessonId);
	if(optionalLesson.isPresent()) {
	 Lesson lesson = optionalLesson.get();
	 return (List<Widget>) lesson.getWidgets();
	}
	return null;
	}
	
	@PostMapping("/api/lesson/{lid}/assignment")
	public Widget createWidget(
			@PathVariable(name="lid") int lessonId,
			@RequestBody Widget newWidget) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if(data.isPresent()) {
			
			return widgetRepository.save(newWidget);
		
			}
		
		return null;
		
		}
	
	
	   
	@GetMapping("/api/assignment")
    public List<Widget> findAllWidgets(){
 	   return (List<Widget>) widgetRepository.findAll();
 	   
 	   }
	   
	   @DeleteMapping("/api/assignment/{widgetId}")
	   public void deleteWidget(
	   @PathVariable("widgetId") int id) {
	   	widgetRepository.deleteById(id);
	   }
	
	
	


}
