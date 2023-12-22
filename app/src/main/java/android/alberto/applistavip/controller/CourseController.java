package android.alberto.applistavip.controller;

import android.alberto.applistavip.model.entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseController {
    private final List<Course> courseList = new ArrayList<>();

    public List<Course> getListCourses() {
        courseList.add(new Course("Java"));
        courseList.add(new Course("PHP"));
        courseList.add(new Course("Web Development"));
        courseList.add(new Course("Android Development"));
        courseList.add(new Course("Kotlin"));
        courseList.add(new Course("Ruby"));

        return courseList;
    }

    public ArrayList<String> courseListSpinner() {
        ArrayList<String> data = new ArrayList<>();

        for (Course course : getListCourses()) {
            data.add(course.getName());
        }

        return data;
    }
}
