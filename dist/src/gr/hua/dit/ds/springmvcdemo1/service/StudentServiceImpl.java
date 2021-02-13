package gr.hua.dit.ds.springmvcdemo1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.ds.springmvcdemo1.dao.StudentDAO;
import gr.hua.dit.ds.springmvcdemo1.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	// inject the StudentDAO
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);
	}

	@Override
	@Transactional
	public List<Student> getCourseStudents(int courseId) {
		return studentDAO.getCourseStudents(courseId);
	}

}