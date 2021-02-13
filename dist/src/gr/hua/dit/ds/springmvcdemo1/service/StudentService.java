package gr.hua.dit.ds.springmvcdemo1.service;

import java.util.List;

import gr.hua.dit.ds.springmvcdemo1.entity.Student;

public interface StudentService {
	public List<Student> getStudents();

	public void saveStudent(Student student);
	
	public Student getStudent(int id);

	public void deleteStudent(int id);
	
	public List<Student> getCourseStudents(int courseId);

}