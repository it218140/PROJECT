package gr.hua.dit.ds.springmvcdemo1.service;

import java.util.List;

import gr.hua.dit.ds.springmvcdemo1.entity.Teacher;

public interface TeacherService {
	public List<Teacher> getTeachers();

	public void saveTeacher(Teacher teacher);
	
	public Teacher getTeacher(int id);

	public void deleteTeacher(int id);
}