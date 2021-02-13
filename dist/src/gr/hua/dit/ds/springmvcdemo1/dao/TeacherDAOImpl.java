  
package gr.hua.dit.ds.springmvcdemo1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.ds.springmvcdemo1.entity.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Teacher> getTeachers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Teacher> query = currentSession.createQuery("from Teacher order by lastName", Teacher.class);

		// execute the query and get the results list
		List<Teacher> teachers = query.getResultList();

		// return the results
		return teachers;
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		if (teacher.getId() != 0) {
		// update the teacher
			currentSession.update(teacher);
		}
		else {
			// save the teacher
		currentSession.save(teacher);
		}

	}

	@Override
	public Teacher getTeacher(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Teacher
		Teacher teacher = currentSession.get(Teacher.class, id);
		return teacher;
	}

	@Override
	public void deleteTeacher(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the teacher
		Teacher teacher = currentSession.get(Teacher.class, id);

		// delete teacher
		currentSession.delete(teacher);

	}

}