public class studentTest {
public static void main(String[]args) {
	student[] studentArray = new student[3];

	studentArray[0] = new student("Jacob Gallagher","Biotechnology",1001);
	studentArray[1] = new student("Frank Simons","CSSE",1002);
	studentArray[2] = new student("Louise Johnsen","Computational Thinking",1003);

	studentArray[0].showStudent();
	studentArray[1].showStudent();
	studentArray[2].showStudent();

	studentArray[0].setStudentCourse("CSSE");
	studentArray[0].showStudent();

	studentArray[2].setStudentName("Louise Johnson");
	System.out.println(studentArray[2].getStudentName());

	}
}