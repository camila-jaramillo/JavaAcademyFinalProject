package com.globant.university;

import java.util.List;

/**
 * @author Maria Camila Jaramillo Benavides
 * Quality Control Analyst
 */
public class Course {
	
	private String name; 
	private String syllabus;
	private Teacher teacher; 
	private List<Student> student;
	private Classroom classroom; 
	private int courseId; 
	private static int id=0;
	
	/**Constructor where an id is assigned to the new Course
	 * @param name Name of the course 
	 * @param syllabus Description of the course
	 */
	public Course(String name, String syllabus) {
		super();
		this.name = name;
		this.syllabus = syllabus;
		Course.id++;
		this.setCourseId(id);;
	}

	/**
	 *Method that returns a String for printing the name and syllabus of a course
	 */
	public String toString() {
		return "- "+name + " : " + syllabus;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHour() {
		return syllabus;
	}
	public void setHour(String hour) {
		this.syllabus = hour;
	}
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}	

}
 