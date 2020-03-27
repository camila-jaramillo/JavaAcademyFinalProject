package com.globant.university;

import java.text.DecimalFormat;

/**
 * @author Marìa Camila Jaramillo Benavides 
 *Quality Control Analyst 
 */
public class FullTimeTeacher extends Teacher{
	
	/**Constructor of the class FullTimeTeacher using the father class attributes and setting the working hours as 8 and adding 
	 * the final salary by calling the method experience() and salary() 
	 * @param name Name of the teacher
	 * @param baseSalary Base salary of the teacher without the estimations for Full Time Teacher
	 * @param contract Full Time contract 
	 * @param experience Given in years/year months/month and days/day
	 * @param workingHours Set as 56 working hours per week for all Full Time Teachers
	 */
	public FullTimeTeacher(String name, String baseSalary, String contract, String experience, String workingHours) {
		super(name, baseSalary, contract, experience, workingHours);
		this.setWorkingHours("56");
		this.experience();
		this.salary();
	}

	/**
	 *Abstract method taken for the class Teacher with estimates the final salary of a Full Time Teacher by using the formula 
	 *baseSalary*(experience*1.1)
	 */
	@Override
	public void salary() {
		double experience = Double.parseDouble(this.getExperience());
		double salary = Double.parseDouble(this.getBaseSalary());
		double salaryUpdate = salary;
		salary = salary*(experience*1.1);
		DecimalFormat df = new DecimalFormat("###,###,###.##");
		String finalSalary = df.format(salary);
		String baseSalary = df.format(salaryUpdate);
		this.setBaseSalary("$"+baseSalary);
		this.setSalary("$"+finalSalary);
		if(this.getExperience().equals("1")) {
			this.setExperience(this.getExperience()+" year");
		}else
		this.setExperience(this.getExperience()+" years");
	}

}
