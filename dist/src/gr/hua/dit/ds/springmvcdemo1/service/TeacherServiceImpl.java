package gr.hua.dit.ds.springmvcdemo1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.ds.springmvcdemo1.dao.TeacherDAO;
import gr.hua.dit.ds.springmvcdemo1.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	// inject the TeacherDAO
	@Autowired
	private TeacherDAO teacherDAO;
	
	@Override
	@Transactional
	public List<Teacher> getTeachers() {
		return teacherDAO.getTeachers();
	}

	@Override
	@Transactional
	public void saveTeacher(Teacher teacher) {
		teacherDAO.saveTeacher(teacher);
	}

	@Override
	@Transactional
	public Teacher getTeacher(int id) {
		return teacherDAO.getTeacher(id);
	}

	@Override
	@Transactional
	public void deleteTeacher(int id) {
		teacherDAO.deleteTeacher(id);
	}

}