package gr.hua.dit.ds.springmvcdemo1.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.ds.springmvcdemo1.entity.Course;
import gr.hua.dit.ds.springmvcdemo1.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Student> query = currentSession.createQuery("from Student order by lastName", Student.class);

		// execute the query and get the results list
		List<Student> students = query.getResultList();

		// return the results
		return students;
	}

	@Override
	public void saveStudent(Student student) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		if (student.getId() != 0) {
		// update the student
			currentSession.update(student);
		}
		else {
			// save the student
		currentSession.save(student);
		}

	}

	@Override
	public Student getStudent(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Student
		Student student = currentSession.get(Student.class, id);
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the student
		Student student = currentSession.get(Student.class, id);

		// delete student
		currentSession.delete(student);

	}

	@Override
	public List<Student> getCourseStudents(int courseId) {
	Session currentSession = sessionFactory.getCurrentSession();
		
		Course course = (Course) currentSession.createQuery("from  Course where id = " +courseId).getSingleResult();
		System.out.println("course " + course);

		System.out.println("course students " + course.getStudents());

		return course.getStudents();
	}

	@Override
	public List<Student> geStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}