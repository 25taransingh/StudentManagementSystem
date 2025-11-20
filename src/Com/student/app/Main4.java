package Com.student.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {
	private static List<Student> studentList;
	private static Scanner scanner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("****************Student Management System****************");
		

		studentList = new ArrayList<Student>();
		scanner = new Scanner(System.in);
		while (true) {
			System.out.println("*******Welcome*******");
			System.out.println("Select an Option....");
			System.out.println("1. Register a Student");
			System.out.println("2. Find Student with studentId");
			System.out.println("3. List All Student Information");
			System.out.println("4. List Student Information in Sorted Order");
			System.out.println("5. Exit");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				enrollstudent(scanner);
				break;
			case 2:
				findStudentById(scanner);
				break;
			case 3:
				printAllStudentData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;

			default:
				System.out.println("Invalid option selected!!!..Please select from 1 to 5");

			}
		}

	}

	private static void exit() {
		// TODO Auto-generated method stub
		System.exit(0);

	}

	public static void printAllStudentData() {
		if(studentList.size()>0) {
		
		System.out.println("======Print all student data======");
		// TODO Auto-generated method stub
		for (Student student : studentList) {
			student.printStudentInfo();
		}}
		else
		{
			System.err.println("No student found inside the list");
		}

	}

	private static void findStudentById(Scanner scanner2) {
		// TODO Auto-generated method stub
		System.out.println("Enter the STUDENT ID to search the student");
		String studentId = scanner2.next();

		Student studentFound = null;
		try {
			studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found by this student Id!!"));

		} catch (RuntimeException e) {
			System.err.println("No data found by this studentId : " + studentId);

		}

		studentFound.printStudentInfo();
	}

	private static void enrollstudent(Scanner scanner2) {

		System.out.println("Enter Student Name");
		String name = scanner2.next();
		System.out.println("Entered Student Name is " + name);

		System.out.println("Enter Student Age");
		int age = scanner2.nextInt();
		System.out.println("Entered Student age is " + age);

		System.out.println("Enter Student StudentId");
		String studentId = scanner2.next();
		System.out.println("Entered StudentId is " + studentId);

		Student s1 = new Student(name, age, studentId);
		while (true) {
			System.out.println("Enter course to enroll student.......Enter done to exit");
			String course = scanner2.next();
			if (course.equalsIgnoreCase("done")) {
				break;
			}
			s1.enrollCourse(course);
			
			

		}
		studentList.add(s1);
		s1.printStudentInfo();
		

	}

	public static void sortByName() {

		Comparator<Student> studentNameComparator = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(studentList, studentNameComparator);
		printAllStudentData();

	}

	public static Student findStudentById(String studentId) {

		Student result = null;
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data found by this student Id!!"));

		} catch (RuntimeException e) {
			System.err.println("No data found by this studentId : " + studentId);

		}

		return result;
	}

}
