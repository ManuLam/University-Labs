public class student {
String name;
String course;
int studentID;

public student() {
	name = "John Doe";
	course = "Unknown";
	studentID = 0;
    }

public student(String a, String b, int c) {
	name = a;
	course = b;
	studentID = c;
    }

	public String getStudentName() {
		return this.name;
		}

	public String getStudentCourse() {
		return this.course;
		}

	public int getStudentID() {
		return this.studentID;
		}

	public void setStudentName(String a) {
		this.name = a;
		}

	public void setStudentCourse(String a) {
		this.course = a;
		}

	public void showStudent() {
		System.out.println("Name: "+this.name+"\nCourse: "+this.course+"\nStudent ID: "+this.studentID+"\n---");
		}



}