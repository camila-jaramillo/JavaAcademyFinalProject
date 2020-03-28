package com.globant.university;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private String name;
	private List<Course> courses;
	private int studentId;
	private static int id=0;
	
	/**
	 * Constructor of the class Student creating a student by only his name, and assigning an id. 
	 * @param name
	 */
	public Student(String name) {
		super();
		this.name = name;
		Student.id++;
		this.setStudentId(id);
		this.courses = new ArrayList<Course>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 *Method that returns a String for printin the student name, course and ID
	 */
	@Override
	public String toString() {
		return "Student [name=" + name + ", course=" + courses + ", studentId=" + studentId + "]";
	}
	
	/**Method that returns a String for printin the student name, course and ID
	 * @return the id of a student and it name 
	 */
	public String toStringBasicInfo() {
		return "ID: "+studentId+"   Name: "+name;
	}
}
