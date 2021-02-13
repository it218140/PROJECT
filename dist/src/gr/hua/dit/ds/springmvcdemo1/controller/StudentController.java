package gr.hua.dit.ds.springmvcdemo1.controller;

import gr.hua.dit.ds.springmvcdemo1.dao.StudentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/add")
    public String addStudent() {
        return "student-form";

    }
}