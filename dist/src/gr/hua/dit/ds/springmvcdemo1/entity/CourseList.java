package gr.hua.dit.ds.springmvcdemo1.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="CourseList")
@Component
public class CourseList {

	List<Course> courseList;
	
	public List<Course> getCourseList(){
		return courseList; 
	}
	
	public void setCourseList(List<Course> courseList) {
		this.courseList=courseList;
	}
	
}