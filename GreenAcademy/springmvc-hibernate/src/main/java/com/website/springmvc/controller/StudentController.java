package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.entities.Student;
import com.website.springmvc.service.StudentService;

@Controller
@RequestMapping(value = "/views/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView getStudents(ModelAndView model) {
		model.setViewName("students");
		model.addObject("students", studentService.getAll());
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView();
		model.setViewName("studentDetail");
		model.addObject("student", new Student());
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("student") Student student) {
		Student result = studentService.add(student);
		if (result != null) {
			return "redirect:/views/student/";
		} else {
			return "studentDetail";
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("studentDetail");
		model.addObject("student", studentService.get(id));
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", studentService.get(id));
		return "redirect:/views/studentDetail/";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("id") Long id, ModelAndView model) {
		studentService.delete(id);
		model.addObject("students", studentService.getAll());
		return model;
	}
}