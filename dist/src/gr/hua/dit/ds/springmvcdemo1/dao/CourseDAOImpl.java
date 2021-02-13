package gr.hua.dit.ds.springmvcdemo1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.ds.springmvcdemo1.entity.Course;
import gr.hua.dit.ds.springmvcdemo1.entity.Teacher;
import gr.hua.dit.ds.springmvcdemo1.entity.Student;

@Repository
public class CourseDAOImpl implements CourseDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Course> getCourses() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Course> query = currentSession.createQuery("from Course", Course.class);

		// execute the query and get the results list
		List<Course> courses = query.getResultList();

		// return the results
		return courses;
	}

	@Override
	public void saveCourse(Course course) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		if (course.getId() != 0) {
		// update the course
			currentSession.update(course);
		}
		else {
			// save the course
		currentSession.save(course);
		}

	}

	@Override
	public Course getCourse(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Course
		Course course = currentSession.get(Course.class, id);
		return course;
	}

	@Override
	public void deleteCourse(int id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the course
		Course course = currentSession.get(Course.class, id);

		// delete course
		currentSession.delete(course);

	}

	@Override
	public List<Course> getNotTeacherCourses(int teacherId) {

		Session currentSession = sessionFactory.getCurrentSession();
		List<Course> courses = currentSession.createQuery("from Course c where c.teacher!="+teacherId).getResultList();
		System.out.println("not teacher courses " + courses);
		return courses;
	}

	@Override
	public List<Course> getNotStudentCourses(int studentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		String sql="select * from course where course.id not in (select course_id from course_student  inner join student on course_student.student_id = student.id  where student_id = "+studentId +")";
		System.out.println("SQL " + sql);
		// FIXME change setresultTransformer to match Hibernate 5.2
		List<Course> courses = currentSession.createNativeQuery(sql).addScalar("id").addScalar("title").setResultTransformer(Transformers.aliasToBean(Course.class)).getResultList();
		System.out.println("not student courses " + courses);
		return courses;
	}

	@Override
	public List<Course> getStudentCourses(int studentId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Student student = (Student) currentSession.createQuery("from  Student where id = " +studentId).getSingleResult();
		System.out.println("student courses " + student.getCourses());

		return student.getCourses();
		
	}

	@Override
	public List<Course> getTeacherCourses(int teacherId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Teacher teacher = (Teacher) currentSession.createQuery("from  Teacher where id = " +teacherId).getSingleResult();
		System.out.println("teacher courses " + teacher.getCourses());

		return teacher.getCourses();
	}

}