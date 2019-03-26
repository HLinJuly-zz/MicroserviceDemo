package com.microservice.mscourses.controller;

import com.microservice.mscourses.model.Course;
import com.microservice.mscourses.model.Student;
import com.microservice.mscourses.service.StudentRegistrationDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.microservice.mscourses.dao.CourseDAO.courseDB;

@RestController
public class CourseController {

    /*@Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }*/
	
	@Autowired
	StudentRegistrationDelegate studentRegistrationDelegate;
	
	//GetAllCourses
	@RequestMapping(path="/allcourses", method = RequestMethod.GET)
	public Set<Course> getCourses(){
		return courseDB;
	}
	
	@GetMapping(value="/register/{courseName}/{studentId}")
	public Course registerStudent(@PathVariable String courseName, @PathVariable int studentId) {
        /*String url = "http://student-service/students/" + studentId;
        Student student = restTemplate.getForObject(url, Student.class);*/
		Student student = studentRegistrationDelegate.getStudentById(studentId) ;
		
		Course course = courseDB.stream()
				.filter(each->each.getName().equalsIgnoreCase(courseName))
				.collect(Collectors.toList())
				.get(0);
				
		if(student!=null) {
			if(course.getRegisteredStudents()==null||course.getRegisteredStudents().size()==0) {
				Set<Student> students = new HashSet<>();
				course.setRegisteredStudents(students);
			}
			course.getRegisteredStudents().add(student);
		}
		return course;
	}
	
	//Ribbon
	@GetMapping("/ribbonClient")
	public String getRibbonServerFromClient() {
		return studentRegistrationDelegate.getRibbonServerResponse();
	}
	
}
