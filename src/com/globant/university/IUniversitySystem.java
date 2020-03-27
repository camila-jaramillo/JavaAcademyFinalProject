package com.globant.university;

import java.util.List;

public interface IUniversitySystem {
	
	/**Method that prints all the information of a teacher depending the type of teacher
	 */
	public void printTeacherInformation();
	
	/**Method that adds a teacher for an existing course
	 * @param id receives a teacher ID
	 * @return the Teacher added
	 */
	public Teacher addTeacherForCourse(String id);
	
	/**Method that adds a classroom for an existing course
	 * @param classroom_id receives a classroom id
	 * @return the Classroom assigned
	 */
	public Classroom addClassroomForCourse(String classroom_id);
	
	/**Method that finds a list of students for assigning them to a course
	 * @param students_id receives a list id's 
	 * @return a list of Students related with the id's 
	 */
	public List<Student> getCourseStudents(List<String> students_id);
	
	/**Method that adds a course to a student 
	 * @param course the course to be added
	 * @param id the id of the student to add the course
	 */
	public void addCourseToStudent (Course course, String id);
	
	/**Method that adds a course to a teacher
	 * @param course the course to be added
	 * @param id the id of the teacher to add the course
	 */
	public void addCourseToTeacher (Course course, String id);
	
	/**Method that prints the basic information of a unique student
	 * @param id receives the id of a student
	 */
	public void printStudentInformation(int id);
	
	/**Method that creates a new course by receiving the basic parameters for a course
	 * @param name the name of the course
	 * @param description the description of the course
	 * @param teacherId the id of the teacher related to the course
	 * @param listId the list of Id's of the students related to the course
	 */
	public void createNewCourse(String name, String description, int teacherId, List<Integer> listId);
	
	/**Method that verifies the size of the list of students 
	 * @return the number of students in the university
	 */
	public int verifySizeStudents();
	
	/**
	 *Method that prints the teachers basic information
	 */
	public void printTeachers();
	
	/**
	 *Method that prints the students basic information
	 */
	public void printStudents();
	
	/**Method that add a new student to a course 
	 * @param name of the new student
	 * @param courseId of the course
	 * @return a boolean depending if the student was added to the course or not
	 */
	public boolean addStudentCourse(String name, int courseId);
	
	/**Method that return a random classroom for the new course
	 * @param classroom receives the list of classrooms of the unversity
	 * @return classroom a random classroom
	 */
	Classroom randomClassroom(List<Classroom> classroom);
	
}
