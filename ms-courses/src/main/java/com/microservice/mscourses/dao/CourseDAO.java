package com.microservice.mscourses.dao;

import java.util.HashSet;
import java.util.Set;

import com.microservice.mscourses.model.Course;

public class CourseDAO {

    //Database
    public static Set<Course> courseDB = new HashSet<>();
    static {
        courseDB.add(new Course("PHYS101", 3));
        courseDB.add(new Course("CHEM101", 4));
        courseDB.add(new Course("MATH101", 3));
    }
}
