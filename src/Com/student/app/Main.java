package Com.student.app;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("****************Student Management System****************");
		System.out.println("*******Welcome*******");

		Student s1;
		s1 = new Student("Taran", 25, "S-10");
		s1.enrollCourse("java");		
		s1.printStudentInfo();
		
		Student s2;
		s2 = new Student("Kanchan", 30, "S-11");
		s2.enrollCourse("DSA");		
		s2.printStudentInfo();
		
		
		Student s3;
		s3 = new Student("Sanjay", 30, "S-12");
		s3.enrollCourse("Devops");		
		s3.printStudentInfo();
		
		
	}

}
