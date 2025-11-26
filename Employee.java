

public abstract class Employee {
    String EmployeeId;
    String EmployeeName;
    double Salary;
    String DepartmentId;

    boolean isReceivedSalary = false;


    Employee(String EmployeeId, String EmployeeName, double Salary, String DepartmentId) {
        this.EmployeeId = EmployeeId;
        this.EmployeeName = EmployeeName;
        this.Salary = Salary;
        this.DepartmentId = DepartmentId;
    }
    String getEmployeeId() {
        return EmployeeId;
    }
    abstract void EmployeeDetails();
    void CheckIn(){
        System.out.println(this.EmployeeName + " is checking in.");
    }
    void ReceiveSalary(){
        System.out.println(this.EmployeeId+ " Received the Salary " + this.Salary);
        isReceivedSalary = true;
    }
}


class Teacher extends Employee {
    Teacher(String EmployeeId, String EmployeeName, double Salary, String DepartmentId) {
        super(EmployeeId, EmployeeName, Salary, DepartmentId);

    }

    public void EmployeeDetails(){

        System.out.println("Teacher Details:");
        System.out.println("Employee ID: " + EmployeeId);
        System.out.println("Employee Name: " + EmployeeName);
        System.out.println("Salary: " + Salary);
        System.out.println("Department ID: " + DepartmentId);

    }
}



class SupportStaff extends Employee {
    SupportStaff(String EmployeeId, String EmployeeName, double Salary, String DepartmentId) {
        super(EmployeeId, EmployeeName, Salary, DepartmentId);



    }

    public void EmployeeDetails(){

        System.out.println("Support Staff Details:");
        System.out.println("Employee ID: " + EmployeeId);
        System.out.println("Employee Name: " + EmployeeName);
        System.out.println("Salary: " + Salary);
        System.out.println("Department ID: " + DepartmentId);

    }

}