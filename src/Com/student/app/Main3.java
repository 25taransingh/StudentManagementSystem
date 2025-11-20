package Com.student.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {
	private static List<Student> studentList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("****************Student Management System****************");
		System.out.println("*******Welcome*******");

		studentList = new ArrayList<Student>();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Strudent Name....");
		String name=scanner.next();//to get the inout as a string we use next() method.
		System.out.println("Yoo have entered "+name);
		
		// to read integer value from console we use method readInt().
		System.out.println("Enter Strudent Age....");
		int age=scanner.nextInt();//if wants to readinput in int format
		System.out.println("Yoo have entered "+age);
		
		
		
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
		System.out.println(studentList);

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
