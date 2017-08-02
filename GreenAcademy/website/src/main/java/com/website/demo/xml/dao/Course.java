package com.website.demo.xml.dao;

import java.util.HashSet;
import java.util.Set;

public class Course implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String courseName;
	private Set<HomeWork> homeworks = new HashSet<HomeWork>();

	public Course() {
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<HomeWork> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(Set<HomeWork> homeworks) {
		this.homeworks = homeworks;
	}
	
	@Override
	public String toString() {
		return String.format("{Course_%s: %s}", id, courseName);
	}
}