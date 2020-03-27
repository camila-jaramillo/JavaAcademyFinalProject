package com.globant.university;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class University implements IUniversitySystem {
	
	private String name;
	private List<Teacher> teachers; 
	private List<Student> students;
	private List<Classroom> classroom;
	private List<Course> courses;
	
	public University(String name){
		this.name = name;
		this.teachers = new ArrayList<Teacher>();
		this.students = new ArrayList<Student>();
		this.classroom = new ArrayList<Classroom>();
		this.courses = new ArrayList<Course>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Classroom> getClassrom() {
		return classroom;
	}
	public void setClassrom(List<Classroom> classrom) {
		this.classroom = classrom;
	}
	public List<Classroom> getClassroom() {
		return classroom;
	}
	public void setClassroom(List<Classroom> classroom) {
		this.classroom = classroom;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
		
	public void printStudentInformation(int id){
		for(Student student : students) {
			if(student.getStudentId()==id){
				System.out.println("\nID: "+student.getStudentId()+" Name: "+student.getName());
				for(Course course : student.getCourses()){
					System.out.println(course.toString());
				}
			}
		}
	}
	
	public void createNewCourse(String name, String description, int teacherId, List<Integer> listId){
		
		List<Student> listStudents = new ArrayList<Student>();
		for(Teacher teacher: this.teachers) {
			if(teacher.getTeacherId()==teacherId){
				Course course = new Course(name,description);
				this.courses.add(course);
				course.setTeacher(teacher);
				course.setClassroom(this.randomClassroom(this.classroom));
				teacher.getCourse().add(course);
				for(Student student: this.students){
					for(Integer inte : listId){
						if(student.getStudentId()==inte){
							listStudents.add(student);
							student.getCourses().add(course);
						}
					}
				}
				course.setStudent(listStudents);
			}
		}
	}
	
	public Classroom randomClassroom(List<Classroom> classroom){
		 Random rand = new Random(); 
	        return classroom.get(rand.nextInt(classroom.size())); 
	}
	
	public int verifySizeStudents() {
		return students.size();
	}
	
	
	public void printTeachers() {
		for(Teacher teacher: this.teachers){
			System.out.println("ID: "+teacher.getTeacherId()+" Name: "+teacher.getName());
		}
	}
	
	public void printStudents(){
		for(Student student: this.students){
			System.out.println("ID: "+student.getStudentId()+" Name: "+student.getName());
		}
	}
	
	public boolean addStudentCourse(String name, int courseId) {
		for (Course course : this.courses) {
			if(courseId==course.getCourseId()){
				Student student = new Student(name);
				course.getStudent().add(student);
				student.getCourses().add(course);
				return true;
			}
		}
		return false;
	}
	
	public void printTeacherInformation(){
		
		for (Teacher teacher: this.getTeachers()){
			System.out.println("Teacher "+teacher.getName()+": \n");
			if(teacher.getContract().contentEquals("Full Time")){
				System.out.println(teacher.toStringFullTime());
			}else {
				System.out.println(teacher.toStringPartTime());
			}
			System.out.println("Courses:");
			for(Course course: teacher.getCourse()){
				System.out.println(course.toString());
			}
			System.out.println("\n------------------------------------------------------------------------------"
					+ "-----------------------------------------------------------"+"\n");
		}
	}
	
	public void printCoursesInformation(){
		for(Course course : this.getCourses()){
			System.out.println(course.getCourseId()+". " +"Class: "+course.getName()+"\n");
		}
	}
	
	public void printCourseCompleteInformation(int id){
		for(Course course: this.getCourses()) {
			if(course.getCourseId()==id){
				System.out.println("Course ID: "+course.getCourseId()+" ["+course.getName()+", "+course.getSyllabus()+", "+
				course.getClassroom().getBuilding()+", Room: "+course.getClassroom().getNumber()+"]");
				System.out.println("Teacher: "+course.getTeacher().getName());
				System.out.println("------------------------------------------------------------------------------"
						+ "-----------------------------------------------------------");
				System.out.println("Course Students");
				System.out.println("--------------------------------------");
				for(Student student: course.getStudent() ){
					System.out.println(student.toStringBasicInfo());
				}
				System.out.println("");
			}
		}
	}
	

	public Teacher addTeacherForCourse(String id){
		for (Teacher t: this.getTeachers()) {
			if (t.getTeacherId() == Integer.parseInt(id)) {
				return t;
			}
		}
		return null;
	}
	
	public Classroom addClassroomForCourse(String classroom_id) {
		for (Classroom t: this.getClassroom()) {
			if (t.getClassroomId() == Integer.parseInt(classroom_id)) {
				return t;
			}
		}
		return null;
	}
	
	public List<Student> getCourseStudents(List<String> students_id) {
		List<Student> students = new ArrayList<Student>();
		for (String id: students_id) {
			for (Student s: this.getStudents()) {
				if (s.getStudentId() == Integer.parseInt(id)) {
					students.add(s);
				}
			}
		}
		return students;
	}
	
	public void addCourseToStudent (Course course, String id) {
		for (int i = 0; i < this.getStudents().size(); i++ ) {
			if (this.getStudents().get(i).getStudentId() == Integer.parseInt(id)) {
				this.getStudents().get(i).getCourses().add(course);
			}
		}
	}
	
	public void addCourseToTeacher (Course course, String id) {
		for (int i = 0; i < this.getTeachers().size(); i++ ) {
			if (this.getTeachers().get(i).getTeacherId() == Integer.parseInt(id)) {
				this.getTeachers().get(i).getCourse().add(course);
			}
		}
	}
	
}
