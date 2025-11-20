package Com.student.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	private static List<Student> studentList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("****************Student Management System****************");
		System.out.println("*******Welcome*******");

		studentList = new ArrayList<Student>();

		Student s1;
		s1 = new Student("Taran", 25, "S-10");

		Student s2;
		s2 = new Student("Kanchan", 30, "S-11");

		Student s3;
		s3 = new Student("Sanjay", 30, "S-12");

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);

		// System.out.println(studentList);
		Student studentDetail = findStudentById("S-11");
		System.out.println(studentDetail);
		sortByName();

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
