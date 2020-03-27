package com.globant.university;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author María Camila Jaramillo Benavides 
 * Quality Control Analyst
 *
 */
public abstract class Teacher {
	
	protected String name; 
	protected String baseSalary;
	protected String contract;
	protected String experience; 
	protected String workingHours; 
	protected String salary;
	protected List<Course> course;
	protected int teacherId;
	protected static int id=0;
	
	/**Constructor using fields
	 * @param name Name of the teacher
	 * @param baseSalary Base salary of the teacher without the estimations Full Time Teacher/Part Time teacher
	 * @param contract Full Time / Part Time 
	 * @param experience Given in years/year months/month and days/day
	 * @param workingHours The working hours per week of a Part Time Teacher/ Full Time Teacher
	 */
	public Teacher(String name, String baseSalary, String contract, String experience, String workingHours){
		this.name = name;
		this.baseSalary = baseSalary;
		this.contract = contract; 
		this.experience = experience; 
		this.workingHours = workingHours;
		Teacher.id++;
		this.setTeacherId(id);
		this.course = new ArrayList<Course>();
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(String baseSalary) {
		this.baseSalary = baseSalary;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	public abstract void salary();
	
	/**
	 * Method that returns a String for printing a Part Time teacher 
	 * @return PartTimeTeacherString
	 */
	public String toStringPartTime() {
		return "ID: "+teacherId+"\n"+"Base Salary: "+baseSalary+"\n"+"Final Salary:"+salary+"\n"+"Working hours per week: "+workingHours;
	}
	
	/**
	 * Method that returns a String for printing a Full Time teacher 
	 * @return FullTimeTeacherString
	 */
	public String toStringFullTime() {
		return "ID: "+teacherId+"\n"+"Base Salary: "+baseSalary+"\n"+"Final Salary:"+salary+"\n"+"Experience "+experience;
	}
	
	/**
	 * Method that turns the experience day/days - month/months - year/years in years
	 */
	public void experience(){
		String experience = this.getExperience(); 
		StringTokenizer token = new StringTokenizer(experience," ");
		String number = token.nextToken().trim();
		String time = token.nextToken().trim();
		
		if(time.equals("day")||time.equals("days")){
			number = "1"; 
		}
		if(time.equals("month")||time.equals("months")){
			number = "1"; 
		}
		this.setExperience(number);
	}

}
