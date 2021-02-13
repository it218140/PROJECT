package gr.hua.dit.ds.springmvcdemo1.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="TeacherList")
@Component
public class TeacherList {

	List<Teacher> teacherList;
	
	public List<Teacher> getTeacherList(){
		return teacherList; 
	}
	
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList=teacherList;
	}
	
}
