package gr.hua.dit.ds.springmvcdemo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.ds.springmvcdemo1.entity.Teacher;
import gr.hua.dit.ds.springmvcdemo1.service.CourseService;
import gr.hua.dit.ds.springmvcdemo1.service.TeacherService;
import gr.hua.dit.ds.springmvcdemo1.entity.Course;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	// inject the teacher service
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/list")
	public String listTeachers(Model model) {
		
		// get teachers from the service
		List<Teacher> teachers = teacherService.getTeachers();
		
		// add the teachers to the model
		model.addAttribute("teachers",teachers);
		
		// add page title
		model.addAttribute("pageTitle", "List Teachers");
		return "list-teachers";
	}
	
	@GetMapping("/{id}")
	public String getTeacher(Model model, @PathVariable("id") int id) {
		// get the teacher
		Teacher teacher = teacherService.getTeacher(id);
		
		model.addAttribute("teacher", teacher);
		
		return "teacher-form";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		
		// add page title
		model.addAttribute("pageTitle", "Add Teacher");
		return "teacher-form";
	}
	
	@PostMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		// save the teacher using the service
		teacherService.saveTeacher(teacher);
		
		return "redirect:/teacher/list";
	}
	
	@GetMapping("/assignCourse/{id}")
	public String assignCourse(Model model,  @PathVariable("id") int id) {
		Teacher teacher = teacherService.getTeacher(id);
	    List<Course> courses=courseService.getNotTeacherCourses(id);
	    model.addAttribute("courses", courses);
	    model.addAttribute("teacher", teacher);
		return "assign-course";
	}
	
	@PostMapping("/assignCourse/{id}")
	public String assignCourseToTeacher(@PathVariable("id") int id, @RequestParam("courseId") int courseId) {
		Teacher teacher = teacherService.getTeacher(id);
		Course course = courseService.getCourse(courseId);
		course.setTeacher(teacher);
		courseService.saveCourse(course);
		return "redirect:/teacher/list";
	}

}