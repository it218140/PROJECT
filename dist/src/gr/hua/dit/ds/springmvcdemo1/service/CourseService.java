package gr.hua.dit.ds.springmvcdemo1.service;

import java.util.List;

import gr.hua.dit.ds.springmvcdemo1.entity.Course;

public interface CourseService {
	public List<Course> getCourses();

	public void saveCourse(Course course);
	
	public Course getCourse(int id);

	public void deleteCourse(int id);

	public List<Course> getNotTeacherCourses(int teacherId);
	
	public List<Course> getTeacherCourses(int teacherId);

	
	public List<Course> getNotStudentCourses(int studentId);
	
	public List<Course> getStudentCourses(int studentId);


}