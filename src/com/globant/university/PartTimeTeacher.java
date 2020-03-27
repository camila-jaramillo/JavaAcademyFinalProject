package com.globant.university;

import java.text.DecimalFormat;

public class PartTimeTeacher extends Teacher {

	/**Constructor of the class PartTimeTeacher using the father class attributes and adding 
	 * the final salary by calling the method experience() and salary() 
	 * @param name Name of the teacher
	 * @param baseSalary Base salary of the teacher without the estimations for Part Time Teacher
	 * @param contract Part Time contract 
	 * @param experience Given in years/year months/month and days/day
	 * @param workingHours The working hours per week of a Part Time Teacher
	 */
	public PartTimeTeacher(String name, String baseSalary, String contract, String experience, String workingHours) {
		super(name, baseSalary, contract, experience, workingHours);
		this.experience();
		this.salary();
	}
	
	/**
	 Abstract method taken for the class Teacher with estimates the final salary of a Part Time Teacher by using the formula 
	 *baseSalary*(BaseSalary*workingHours)
	 */
	@Override
	public void salary() {
		double workingHours = Double.parseDouble(this.getExperience());
		double salary = Double.parseDouble(this.getBaseSalary());
		double salaryUpdate = salary;
		salary = salary*(4*workingHours);
		DecimalFormat df = new DecimalFormat("###,###,###.##");
		String baseSalary = df.format(salaryUpdate);
		this.setBaseSalary("$"+baseSalary);
		String finalSalary = df.format(salary);
		this.setSalary("$"+finalSalary);
		if(this.getWorkingHours().equals("1")) {
			this.setWorkingHours(this.getWorkingHours()+" hour");
		}else
		this.setWorkingHours(this.getWorkingHours()+" hours");
	}
	
}
