package com.globant.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.globant.persistence.FileManagement;
import com.globant.university.IUniversitySystem;
import com.globant.university.University;

public class UniversitySystemTest {

	public static void main(String[] args) {
		
		IUniversitySystem university = new University("Frida Kahlo University");
		University u = (University) university;
		FileManagement.classroomFile((University) university);
		FileManagement.teachersFile((University) university);
		FileManagement.studentsFile((University) university);
		FileManagement.courseFile((University) university);
		
		boolean cycle=true;
		Scanner scanner = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		
		do {
			
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("-----------------------------------Principal Menu --------------------------------------");
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.println("");
			System.out.println("1. Print all the professors with its data");
			System.out.println("2. Print all the courses"); 
			System.out.println("3. Create a new Student and add it to an existing course");
			System.out.println("4. Create a new course and add a teacher, student and relevant information");
			System.out.println("5. List all the courses in which a given student is included");
			System.out.println("6. Exit");
			
			System.out.println("\n"+"Please write the option you want below:");
			int option = scanner.nextInt();
			String binaryOption;
		
			switch(option){
				case 1: 
					System.out.println("\n"+"The teachers in the university "+u.getName()+" are:"+"\n");
					System.out.println("------------------------------------------------------------------------------"
							+ "-----------------------------------------------------------");
					u.printTeacherInformation();
					System.out.println("\n");
					System.out.println("Press Any Key To Continue...");
					new java.util.Scanner(System.in).nextLine();
					break;
				case 2: 
					System.out.println("\n"+"The courses in the university "+u.getName()+" are:");
					System.out.println("------------------------------------------------------------------------------"
							+ "-----------------------------------------------------------");
					u.printCoursesInformation();
					System.out.println("Do you want to search the complete information of a course: Teacher and Students (Yes/No)"
							+ " Please enter the option below:");
					binaryOption = scan.nextLine();
					
					if(binaryOption.equals("Yes")||binaryOption.equals("YES")||binaryOption.equals("yes")) {
						System.out.println("\n"+"Please enter the number of the course you want the information of: ");
						option = scanner.nextInt();
						System.out.println("\n"+"------------------------------------------------------------------------------"
								+ "-----------------------------------------------------------");
						u.printCourseCompleteInformation(option);
					}else break;
					System.out.println("Press Any Key To Continue...");
					new java.util.Scanner(System.in).nextLine();
					break;
				case 3: 
					System.out.println("Please enter the name of the new Student: ");
					binaryOption = scan.nextLine();
					System.out.println("Please enter the id of an exiting course: ");
					option = scanner.nextInt();
					boolean aux = u.addStudentCourse(binaryOption,option);
					if(aux==true){
						System.out.println("The new student was succesfully added with the respective course");
					}else {
						System.out.println("Sorry, we couldn't add the new student the ID course doesn't exist");
					}
					System.out.println("Press Any Key To Continue...");
					new java.util.Scanner(System.in).nextLine();
					break;
				case 4: 
					
					System.out.println("Please enter the name of the new course: ");
					binaryOption = scan.nextLine();
					String name = binaryOption; 
					System.out.println("Please enter the description of the new course: ");
					binaryOption = scan.nextLine();
					String description = binaryOption;
					System.out.println("\n");
					u.printTeachers();
					System.out.println("\n");
					System.out.println("Please enter the ID of an existing teacher, if the ID doesn't exist the course would not be created");
					option = scanner.nextInt();
					int teacher_id = option;
					System.out.println("\n");
					u.printStudents();
					System.out.println("\n");
					System.out.println("Please enter the number of students you are going to add to the course,"
							+ "if the number of students is greater that the number of existing students the course would not be created");
					option = scanner.nextInt();
					int numberStudents = option;
					if(numberStudents>u.verifySizeStudents()) {
						break;
					}
					System.out.println("Please enter one by one the ID's of the students you want to add to the course"
							+ "if the ID doesn't exist the student wont be added to de course (*write ID, tap enter)");
					List<Integer> listId = new ArrayList<Integer>();
					for(int i=0; i<numberStudents; i++) {
						option = scanner.nextInt();
						listId.add(option);
					}
					u.createNewCourse(name, description, teacher_id, listId);
					System.out.println("Press Any Key To Continue...");
					new java.util.Scanner(System.in).nextLine();
					break;
				case 5: 
					System.out.println("\n");
					u.printStudents();
					System.out.println("\n");
					System.out.println("Please enter the id of the student you would like to search information of:");
					option = scanner.nextInt();
					u.printStudentInformation(option);
					System.out.println("\n");
					System.out.println("Press Any Key To Continue...");
					new java.util.Scanner(System.in).nextLine();
					break;
				case 6: 
					System.out.println("Bye!! See you soon ;)");
					cycle=false;
					break;
			}
			
			
		}while(cycle==true);
		
		scanner.close();
		scan.close();

	}

}
