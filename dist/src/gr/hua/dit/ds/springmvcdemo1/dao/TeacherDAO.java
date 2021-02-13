package gr.hua.dit.ds.springmvcdemo1.dao;

import java.util.List;

import gr.hua.dit.ds.springmvcdemo1.entity.Teacher;



public interface TeacherDAO {
	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher teacher);
	
	public Teacher getTeacher(int id);

	public void deleteTeacher(int id);
}