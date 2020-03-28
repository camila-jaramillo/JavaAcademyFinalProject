package com.globant.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.globant.university.Classroom;
import com.globant.university.Course;
import com.globant.university.FullTimeTeacher;
import com.globant.university.PartTimeTeacher;
import com.globant.university.Student;
import com.globant.university.Teacher;
import com.globant.university.University;

public class FileManagement {
	
	/**Method that gets from a file a list of courses and creates them
	 * @param university the university in which the courses will be added 
	 */
	public static void courseFile(University university){
		
		try{
			String fileLine, name, syllabus, teacher_id, classroom_id;
			List<String> students_id = new ArrayList<String>();
			FileReader fileReader = new FileReader("courses.txt");
			BufferedReader bufferReader = new BufferedReader(fileReader);
			
			while ((fileLine = bufferReader.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(fileLine, "*");
				int a = 0;
				String stringTokenizer;
				name = null;
				syllabus = null;
				teacher_id = null;
				classroom_id = null;
				while (token.hasMoreTokens()) {
					a++;
					stringTokenizer = token.nextToken();
					if (a == 1) { name = stringTokenizer; };
					if (a == 2) { syllabus = stringTokenizer; };
					if (a == 3) { teacher_id = stringTokenizer; };
					if (a == 4) { classroom_id = stringTokenizer; };
					if (a == 5) {
						StringTokenizer colon = new StringTokenizer(stringTokenizer, ",");
						while (colon.hasMoreTokens()) {
							stringTokenizer = colon.nextToken();
							students_id.add(stringTokenizer);
						}
					}
				}
				Course course = new Course(name,syllabus);
				course.setTeacher(university.addTeacherForCourse(teacher_id));
				course.setClassroom(university.addClassroomForCourse(classroom_id));
				course.setStudent(university.getCourseStudents(students_id));
				university.getCourses().add(course);
				for (String student: students_id) {
					university.addCourseToStudent(course, student);
				}
				university.addCourseToTeacher(course, teacher_id);
				students_id.clear();
			}
			bufferReader.close();	
		}catch(Exception e){
			System.out.println("Unexpected Exeption");
		}
		
	}
	
	/**Method that gets from a file a list of classrooms and creates them
	 * @param university the university in which the classrooms will be added 
	 */
	public static void classroomFile(University university){
		File inFile = new File("./"+"classrooms.txt");
		Scanner input = null; 
		try{
			input = new Scanner(inFile); 
			String fileLine, number, building;
			while(input.hasNext()) {
				fileLine = input.nextLine().trim();
				StringTokenizer token = new StringTokenizer(fileLine,"*");
				number = token.nextToken().trim();
				building = token.nextToken().trim();
				Classroom classroom = new Classroom(number,building);
				university.getClassrom().add(classroom);

			}
		}catch(Exception e){
			System.out.println("Unexpected Exeption");
		}
		finally {
			input.close();
		}
	}
	
	/**Method that gets from a file a list of teachers and creates them
	 * @param university university the university in which the teachers will be added
	 */
	public static void teachersFile(University university){
		File inFile = new File("./"+"teachers.txt");
		Scanner input = null; 
		try{
			input = new Scanner(inFile); 
			String fileLine, name, baseSalary, contract, experience, workingHours;
			while(input.hasNext()){
				fileLine = input.nextLine().trim();
				StringTokenizer token = new StringTokenizer(fileLine,"*");
				name = token.nextToken().trim();
				baseSalary = token.nextToken().trim();
				contract = token.nextToken().trim();
				experience = token.nextToken().trim();
				workingHours = token.nextToken().trim();
				if (contract.equals("Part Time")){
					Teacher teacher = new PartTimeTeacher(name,baseSalary,contract,experience,workingHours);
					university.getTeachers().add(teacher);
				}else {
					Teacher teacher = new FullTimeTeacher(name,baseSalary,contract,experience,"8");
					university.getTeachers().add(teacher);
				}
			}
		}catch(Exception e){
			System.out.println("Unexpected Exeption");
		}
		finally {
			input.close();
		}	
	}
	
	/**Method that gets from a file a list of students and creates them
	 * @param university university university the university in which the students will be added
	 */
	public static void studentsFile(University university){
		File inFile = new File("./"+"students.txt");
		Scanner input = null; 
		try{
			input = new Scanner(inFile); 
			String fileLine,name;
			while(input.hasNext()) {
				fileLine = input.nextLine().trim();
				StringTokenizer token = new StringTokenizer(fileLine,"*");
				name = token.nextToken().trim();
				Student student = new Student(name);
				university.getStudents().add(student);
			}
		}catch(Exception e){
			System.out.println("Unexpected Exeption");
		}
		finally {
			input.close();
		}	
	}
	

}
