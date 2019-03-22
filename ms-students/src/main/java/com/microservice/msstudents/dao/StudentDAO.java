package com.microservice.msstudents.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.microservice.msstudents.model.Student;
@Repository
public class StudentDAO {

	//Database
	public static List<Student> studentDB = new ArrayList<Student>();
	static {
		studentDB.add(new Student(1, "Alice", "Physics"));
		studentDB.add(new Student(2, "Bradly", "Chemistry"));
		studentDB.add(new Student(3, "Cathy", "Mathematics"));
	}
}
