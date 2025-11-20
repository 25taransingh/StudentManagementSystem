package Com.student.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>();
		}

	}

	public boolean validateStudentId(String studentId) {
		String studentIdRegex = "^S-[0-9]+$";
		Pattern studentIdpattern = Pattern.compile(studentIdRegex);
		Matcher studentIdpatternmatcher = studentIdpattern.matcher(studentId);
		if (studentIdpatternmatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid input StudentId");
			return false;
		}

	}

	public boolean validateName(String name) {

		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Input Name");
			return false;
		}
	}
	
	public boolean validCourseName(String course) {
		if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Devops"))
		{
			return true;
		}
		else {
			System.err.println("Invalid course name please enter [java,DSA,Devops]");
			return false;
		}
		

	}

	public void enrollCourse(String course) {
		if(validCourseName(course)) {

		if (courses.contains(course)) {
			System.err.println("Student is already enrolled to " + course);
		} else {
			courses.add(course);
			
			System.out.println("Student enrolled to " + course + " successfully");

		}

	}}

	public void printStudentInfo() {

		System.out.println("========Student Information ========");
		System.out.println("Student name :" + name);
		System.out.println("Student age :" + age);
		System.out.println("Student studentId :" + studentId);
		System.out.println("Student courses :" + courses);

	}
	// TODO Auto-generated method stub

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Input age is invalid");
			return false;
		}

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}

}
