package android.alberto.applistavip.controller;

import android.alberto.applistavip.model.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseController {
    private List<Course> courseList = new ArrayList<>();

    public List getListCourses() {
        courseList.add(new Course("Java"));

        return courseList;
    }
}
