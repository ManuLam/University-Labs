public class TestEmployee {
public static void main(String[]args) {
    Employee e1 = new Employee("Tom Daly", "Teacher", 30000.00f, 1001);
    Employee e2 = new Employee("Mary Murphy", "Developer", 45000.00f,1002);
    Employee e3 = new Employee();

    System.out.println("Employee 2 is called " + e2.getName() + "\nThey are a " + e2.getJobTitle()  + "\nTheir salary is " + e2.getSalary() + "\nTheir Employee ID number is " + e2.getID());
    e3.setName("Michael Higgins");
    e3.setJobTitle("President");
    e3.setSalary(1000f);

    e1.showEmp();
    e2.showEmp();
    e3.showEmp();
    System.out.println(e1.toString());
}
}