package gr.hua.dit.ds.springmvcdemo1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.ds.springmvcdemo1.dao.CourseDAO;
import gr.hua.dit.ds.springmvcdemo1.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	// inject the CourseDAO
	@Autowired
	private CourseDAO courseDAO;
	
	@Override
	@Transactional
	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}

	@Override
	@Transactional
	public void saveCourse(Course course) {
		courseDAO.saveCourse(course);
	}

	@Override
	@Transactional
	public Course getCourse(int id) {
		return courseDAO.getCourse(id);
	}

	@Override
	@Transactional
	public void deleteCourse(int id) {
		courseDAO.deleteCourse(id);
	}

	@Override
	@Transactional
	public List<Course> getNotTeacherCourses(int teacherId) {
		return courseDAO.getNotTeacherCourses(teacherId);
	}

	@Override
	@Transactional
	public List<Course> getNotStudentCourses(int studentId) {
		return courseDAO.getNotStudentCourses(studentId);
	}

	@Override
	@Transactional
	public List<Course> getStudentCourses(int studentId) {
		return courseDAO.getStudentCourses(studentId);
	}

	@Override
	@Transactional
	public List<Course> getTeacherCourses(int teacherId) {
		return courseDAO.getTeacherCourses(teacherId);
	}

}