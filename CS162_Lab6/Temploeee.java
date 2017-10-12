public class Employee {
public String name;
public String jobTitle;
public float salary;
public int employeeID;

    public Employee() {
        name = "NAME";
        jobTitle = "JOBTITLE";
        salary = 0f;
        employeeID = 1003;
    }

    public Employee(String a, String b, float c, int d) {
        name = a;
        jobTitle = b;
        salary = c;
        employeeID = d;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public float getSalary() {
        return salary;
    }

    public int getID() {
        return employeeID;
    }

    public void setName(String x) {
        name = x;
    }

    public void setSalary(float x) {
        if(x<19000) { System.out.println("Entered salary of " + x + " is too low. Salary set at minimum wage of 19000.0");
           this.salary = 19000.00f; }
    }

    public void setJobTitle(String x) {
        this.jobTitle = x;
    }

    public String toString() {
        String s = "";
        s += "NAME: " + name;
        s += "\nJOB TITLE: " + jobTitle;
        s += "\nCURRENT SALARY: " + salary;
        s += "\nEMPLOYEE ID: " + employeeID;
        return s;
    }

    public void showEmp() {
        System.out.println("EMPLOYEE RECORD");
        System.out.println("NAME: " + name);
        System.out.println("JOB TITLE: " + jobTitle);
        System.out.println("CURRENT SALARY: " + salary);
        System.out.println("EMPLOYEE ID: " + employeeID);
    }
}