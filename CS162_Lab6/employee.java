public class employee {
public String name;
public String jobTitle;
public float salary;
public int employeeID;
public int num;

    public employee() {
		name = "name";
		jobTitle = "jobTitle";
		salary = 0;
		employeeID = 0;
		num = 0;
     }

    public employee(String a, String b, float c, int d , int e) {
		name = a;
		jobTitle = b;
		salary = c;
		employeeID = d;
		num = e;
    }

    public static void getInfo(employee x) {
    	System.out.println("Employee " + x.num + " is called "+x.name);
    	System.out.println("They are a " + x.jobTitle);
    	System.out.println("Their salary is " + x.salary);
    	System.out.println("Their Employee ID number is " + getID(x));
    }

    public static void setInfo(employee x, String a, String b, float c) {
    	x.name = a;
    	x.jobTitle = b;
    	x.salary = c;
    }

    public static int getID(employee x) {
    	return x.employeeID;
    }
//
//    public static void showEmp() {
//    	System.out.println(this.name);
//    	System.out.println(this.jobTitle);
//    	System.out.println(this.salary);
//    	System.out.println(this.employeeID);
//    }
//
//    public static void toString() {
//    	System.out.println(this.name);
//    	System.out.println(this.jobTitle);
//    	System.out.println(this.salary);
//    	System.out.println(this.employeeID);
//    }

    public static void main(String[]args) {
    	employee e1 = new employee("Mary Murphy", "Developer" , 4500.00f, 1002 , 2);
		getInfo(e1);
   	}
}