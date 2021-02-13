package gr.hua.dit.ds.springmvcdemo1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/studentform")
	public String showForm() {
		return "student-form";
	}
	
	@RequestMapping(value="/processform", method = RequestMethod.POST)
	public String processFormv2(HttpServletRequest request, Model model) {

	    String theName = request.getParameter("studentName");
	    theName = theName.toUpperCase();

	    String result ="Hello " + theName;

	    model.addAttribute("message",result);

	    return "student";
	}


}
