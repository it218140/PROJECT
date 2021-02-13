package gr.hua.dit.ds.springmvcdemo1.dao;

import java.util.List;

import gr.hua.dit.ds.springmvcdemo1.entity.Student;

public interface StudentDAO {
    public List<Student> geStudents();

	public List<Student> getStudents();

	public void saveStudent(Student student);

	public void deleteStudent(int id);

	public Student getStudent(int id);

	public List<Student> getCourseStudents(int courseId);

}