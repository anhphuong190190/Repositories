package com.website.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.website.springmvc.service.StudentService;

@Controller
@RequestMapping(value = "/views/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getStudents() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		model.addObject("students", studentService.get());
		return model;
	}
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public ModelAndView addStudent() {
		ModelAndView model = new ModelAndView();
		model.setViewName("student");
		model.addObject("student", studentService.get());
		return model;
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView();
		model.setViewName("student");
		model.addObject("student", studentService.get());
		return model;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("name") Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("student");
		model.addObject("student", studentService.get());
		return model;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ModelAndView update(@PathVariable("name") Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("student");
		model.addObject("student", studentService.get());
		return model;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("name") Long id) {
		ModelAndView model = new ModelAndView();
		model.setViewName("student");
		model.addObject("student", studentService.get());
		return model;
	}
}