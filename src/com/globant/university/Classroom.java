package com.globant.university;

public class Classroom {
	
	String number;
	String building;
	private int classroomId;
	private static int id=0;

	public Classroom(String number,String building) {
		super();
		this.number = number;
		this.building = building;
		Classroom.id++;
		this.setClassroomId(id);
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}
	

}
