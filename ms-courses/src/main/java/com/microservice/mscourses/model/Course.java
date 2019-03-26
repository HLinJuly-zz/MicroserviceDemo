package com.microservice.mscourses.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Course {

	private String name;
	private int credits;
	private Set<Student> registeredStudents;
	
	public Course() {}
	
	public Course(String name, int credits) {
		this.name=name;
		this.credits=credits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Set<Student> getRegisteredStudents() {
		return registeredStudents;
	}

	public void setRegisteredStudents(Set<Student> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null) return false;
		if(!(o instanceof Course)) return false;
		Course course=(Course) o;
		return Objects.equals(getName(), course.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName());
	}
}
