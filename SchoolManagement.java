import java.util.Scanner;
import java.util.ArrayList;
public class SchoolManagement {
    String SchoolName ;
    String Address ;
    String ContactNumber;
    String MediumOfStudy;

    ArrayList<SupportStaff>SupportStaffs;

    ArrayList <Teacher>Teachers ;
    private Auditorium auditorium;
    private Playground playground;
    private NoticeBoard noticeBoard;
    private ArrayList<Employee> employees;
    private ArrayList<Classroom> classrooms;
    private ArrayList<Lab> labs;
    private ArrayList<Department> departments;
     ArrayList<Bus> buses;
    private ArrayList<Student> students;
    SchoolManagement(){
        this.buses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        this.labs = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    SchoolManagement(String SchoolName, String Address, String ContactNumber, String MediumOfStudy) {
        this.SchoolName = SchoolName;
        this.Address = Address;
        this.ContactNumber = ContactNumber;
        this.MediumOfStudy = MediumOfStudy;

        this.buses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        this.labs = new ArrayList<>();
        this.departments = new ArrayList<>();
    }
    void RunSchool(){
        boolean b = true;
        String CurrentMenu = "main";
        Scanner user = new Scanner(System.in);
        while(b){
            try {


                if (CurrentMenu.equals("main")) {
                    System.out.println("---------Main menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Bus");
                    System.out.println("B- Student");
                    System.out.println("C- Employee");
                    System.out.println("D- Class");
                    System.out.println("E- NoticeBoard");
                    System.out.println("F- Auditorium");
                    System.out.println("G- ShowSchoolDetails");
                    System.out.println("H- Exit");

                    char c = user.nextLine().charAt(0);


                    if (c == 'A' || c =='a') {
                        CurrentMenu = "Bus";
                    } else if (c == 'B' || c=='b') {
                        CurrentMenu = "Student";
                    } else if (c == 'C' || c == 'c') {
                        CurrentMenu = "Employee";
                    } else if (c == 'D' || c == 'd') {
                        CurrentMenu = "Class";
                    } else if (c == 'E' || c == 'e') {
                        CurrentMenu = "NoticeBoard";
                    } else if (c == 'F' || c=='f') {
                        CurrentMenu = "Auditorium";
                    } else if (c == 'G' || c == 'g') {
                        CurrentMenu = "ShowSchoolDetails";
                    } else if (c == 'H' || c == 'h') {
                        CurrentMenu = "Exit";
                    } else {
                        CurrentMenu = "None";
                    }
                }

                if (CurrentMenu.equals("Bus")) {
                    System.out.println("---------Bus menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Add bus");
                    System.out.println("B- Show bus details");
                    System.out.println("C- Show Seats");
                    System.out.println("D- Go Back");

                    char c = user.nextLine().charAt(0);


                    if (c == 'A' ||c=='a') {
                        CurrentMenu = "Add Bus";
                    } else if (c == 'B'||c=='b') {
                        CurrentMenu = "Show bus details";
                    } else if (c == 'C'||c=='c') {
                        CurrentMenu = "Show Seats";
                    } else if (c == 'D'||c=='d') {
                        CurrentMenu = "main";
                    }
                } else if (CurrentMenu.equals("Add Bus")) {
                    System.out.println("Please enter Bus ID");
                    String busId = user.nextLine();
                    System.out.println("Please enter Driver ID");
                    String DriverId = user.nextLine();
                    System.out.println("How many neighborhoods does the bus support");
                    int neighborhoods = user.nextInt();
                    user.nextLine();

                    ArrayList<String> AreaList = new ArrayList<>();
                    for (int i = 0; i < neighborhoods; i++) {
                        System.out.println("Please enter neighborhood number " + (i + 1));
                        String neighborhood = user.nextLine();
                        AreaList.add(neighborhood);
                    }
                    ArrayList<Student> StudentList = new ArrayList<>();
                    System.out.println("How many students does the bus support");
                    int students = user.nextInt();
                    user.nextLine();
                    for (int i = 0; i < students; i++) {
                        System.out.println("Please enter ID for student number " + (i + 1));
                        String studentId = user.nextLine();
                        System.out.println("is he\nA- Primary\nB- high");
                        char cc = user.nextLine().charAt(0);

                        if (cc == 'A' || cc =='a') {
                            StudentList.add(new PrimaryStudent(studentId));

                        } else if (cc == 'B'||cc =='b') {
                            StudentList.add(new HigherSecondaryStudent(studentId));
                        }

                    }
                    System.out.println("Please enter The Capacity");
                    int capacity = user.nextInt();
                    user.nextLine();

                    Bus bus = new Bus(busId, DriverId, AreaList, capacity, StudentList);
                    this.buses.add(bus);
                    System.out.println("Bus Added Successfully\nPress enter to back to previous menu");
                    user.nextLine();
                    CurrentMenu = "Bus";

                } else if (CurrentMenu.equals("Show bus details")) {
                    for (Bus bus : buses) {
                        bus.BusDetails();

                    }
                    System.out.println("\nPress enter to back to previous menu");
                    user.nextLine();
                    CurrentMenu = "Bus";
                } else if (CurrentMenu.equals("Show Seats")) {
                    System.out.println("Please enter Bus ID to show seats");
                    String busId = user.nextLine();
                    Bus busToShow = findBusById(busId);
                    if (busToShow != null) {
                        busToShow.ShowSeats();
                    } else {
                        System.out.println("Bus not found");
                    }
                    System.out.println("\nPress enter to back to previous menu");
                    user.nextLine();
                    CurrentMenu = "Bus";


                } else if (CurrentMenu.equals("Student")) {
                    System.out.println("---------Student Menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Add Student");
                    System.out.println("B- Show Student Details");
                    System.out.println("C- Pay Fees");
                    System.out.println("D- Go Back");

                    char c1 = user.nextLine().charAt(0);


                    if (c1 == 'A' || c1 =='a') {
                        CurrentMenu = "Add Student";
                    } else if (c1 == 'B' || c1 =='b') {
                        CurrentMenu = "Show Student Details";
                    } else if (c1 == 'C'|| c1=='c') {
                        CurrentMenu = "Pay Fees";
                    } else if (c1 == 'D'|| c1=='d') {
                        CurrentMenu = "main";
                    }
                } else if (CurrentMenu.equals("Add Student")) {
                    System.out.println("Please enter Student ID");
                    String studentId = user.nextLine();
                    System.out.println("Please enter Student Name");
                    String studentName = user.nextLine();
                    System.out.println("Please enter Class ID");
                    String classId = user.nextLine();
                    System.out.println("Please enter Section");
                    int section = user.nextInt();
                    user.nextLine();
                    System.out.println("Please enter Bus ID");
                    String busId = user.nextLine();
                    while(true) {
                        System.out.println("Primary Student or Higher(P/H)");
                        String PoH = user.nextLine();
                        students = new ArrayList<>();
                        if(PoH.equalsIgnoreCase("P")) {
                            Student s = new PrimaryStudent(studentId,studentName,classId,section,busId);
                            students.add(s);
                            break;
                        }else if(PoH.equalsIgnoreCase("H")) {
                            Student s = new HigherSecondaryStudent(studentId,studentName,classId,section,busId);
                            students.add(s);
                            break;
                        }else {
                            System.out.println("Invalid Input");

                        }
                    }


                } else if (CurrentMenu.equals("Show Student Details")) {
                    System.out.println("Please enter Student ID to show student details");
                    String studentId = user.nextLine();
                    Student s = findStudentById(studentId);

                    if(s!=null){
                        s.StudentDetails();
                    } else{
                        System.out.println("Student not found");
                    }
                } else if (CurrentMenu.equals("Pay Fees")) {
                    System.out.println("Please enter Student ID to pay fees");
                    String studentId = user.nextLine();
                    Student s = findStudentById(studentId);
                    if(s!=null){
                        s.PayFees();
                    }else{
                        System.out.println("Student not found");
                    }


                } else if (CurrentMenu.equals("Employee")) {
                    System.out.println("---------Employee Menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Teacher");
                    System.out.println("B- Support Staff");
                    System.out.println("C- main");

                    char c1 = user.nextLine().charAt(0);


                    if (c1 == 'A' || c1 =='a') {
                        CurrentMenu = "Teacher";
                    } else if (c1 == 'B' || c1 =='b') {
                        CurrentMenu = "Support";
                    } else if (c1 == 'C' || c1 =='c') {
                        CurrentMenu = "main";
                    }
                } else if (CurrentMenu.equals("Teacher")) {
                    System.out.println("---------Teacher Menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Show Teacher Details");
                    System.out.println("B- Receive Salary");
                    System.out.println("C- Go Back");

                    char c1 = user.nextLine().charAt(0);

                    if (c1 == 'A' || c1 =='a') {
                        CurrentMenu = "Show Teacher Details";
                    }else if (c1 == 'B' || c1 =='b') {
                        CurrentMenu = "Receive Salary";
                    }else if (c1 == 'C' || c1 =='c') {
                        CurrentMenu = "Employee";
                    }

                } else if (CurrentMenu.equals("Show Teacher Details")) {
                    System.out.println("Please enter Teacher ID to show teacher details");
                    String teacherId = user.nextLine();
                    Employee e = findEmployeeById(teacherId);
                    if(e!=null){
                        e.EmployeeDetails();
                    }else{
                        System.out.println("Teacher not found");
                    }
                }
                else if (CurrentMenu.equals("Receive Salary")) {
                    System.out.println("Please enter Employee ID to receive salary");
                    String empId = user.nextLine();
                    Employee e = findEmployeeById(empId);
                    if(e!=null){
                        e.ReceiveSalary();
                    }else{
                        System.out.println("Employee not found");
                    }

                }

                else if (CurrentMenu.equals("Support")) {
                    System.out.println("---------Support Menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Show Support Staff Details");
                    System.out.println("B- Receive Salary");
                    System.out.println("C- Go Back");

                    char c1 = user.nextLine().charAt(0);

                    if (c1 == 'A' || c1 =='a') {
                        CurrentMenu = "Show Support Staff Details";
                    }else if (c1 == 'B' || c1 =='b') {
                        CurrentMenu = "Receive Salary";
                    }else if (c1 == 'C' || c1 =='c') {
                        CurrentMenu = "Employee";
                    }

                }else if (CurrentMenu.equals("Show Support Staff Details")) {
                    System.out.println("Please enter Employee ID to show support staff details");
                    String empId = user.nextLine();
                    Employee e = findEmployeeById(empId);
                    if(e!=null){
                        e.EmployeeDetails();
                    }
                }
                else if (CurrentMenu.equals("Class")) {
                    System.out.println("---------Class Menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Add Student");
                    System.out.println("B- Assign Teacher");
                    System.out.println("C- Show Details");
                    System.out.println("D- Go Back");

                    char c1 = user.nextLine().charAt(0);


                    if (c1 == 'A' || c1=='a') {
                        CurrentMenu = "Add_Student";
                    } else if (c1 == 'B' || c1=='b') {
                        CurrentMenu = "Assign Teacher";
                    } else if (c1 == 'C' || c1=='c') {
                        CurrentMenu = "Show Details";
                    } else if (c1 == 'D' || c1=='d') {
                        CurrentMenu = "main";
                    }
                } else if (CurrentMenu.equals("Add_Student")) {
                    System.out.println("Please enter Student ID to add student");
                    String studentId = user.nextLine();
                    Student s = findStudentById(studentId);
                    System.out.println("Please enter Class ID to add student");
                    String classId = user.nextLine();
                    Classroom c = findClassById(classId);
                    c.addStudent(s);
                } else if (CurrentMenu.equals("Assign Teacher")) {
                    System.out.println("Please enter Teacher ID to assign teacher");
                    String teacherId = user.nextLine();
                    Teacher t = findTeacherById(teacherId);
                    System.out.println("Please enter Class ID to assign teacher");
                    String classId = user.nextLine();
                    Classroom c = findClassById(classId);
                    c.AssignTeacher(t);
                } else if (CurrentMenu.equals("Show Details")) {
                    System.out.println("Please enter Class ID to Show Details");
                    String ClassID = user.nextLine();
                    Classroom C = findClassById(ClassID);
                    C.ClassDetails();
                } else if (CurrentMenu.equals("NoticeBoard")) {
                    System.out.println("---------NoticeBoard Menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Display");
                    System.out.println("B- Add Content");
                    System.out.println("C- Go Back");
                    char c1 = user.nextLine().charAt(0);

                    if (c1 == 'A' || c1=='a') {
                        CurrentMenu = "Display";
                    } else if (c1 == 'B' || c1=='b') {
                        CurrentMenu = "Add Content";
                    } else if (c1 == 'C' || c1=='c') {
                        CurrentMenu = "main";
                    }

                } else if (CurrentMenu.equals("Display")) {
                } else if (CurrentMenu.equals("Add Content")) {
                } else if (CurrentMenu.equals("Auditorium")) {
                    System.out.println("---------Auditorium Menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Book Auditorium");
                    System.out.println("B- Show Event Details");
                    System.out.println("C- Show Seats");
                    System.out.println("D- Go Back");
                    char c1 = user.nextLine().charAt(0);

                    if (c1 == 'A' || c1=='a') {
                        CurrentMenu = "Book Auditorium";
                    } else if (c1 == 'B' || c1=='b') {
                        CurrentMenu = "Show Event Details";
                    } else if (c1 == 'C' || c1=='c') {
                        CurrentMenu = "Show Seats";
                    } else if (c1 == 'D' || c1=='d') {
                        CurrentMenu = "main";
                    }
                } else if (CurrentMenu.equals("Book Auditorium")) {
                } else if (CurrentMenu.equals("Show Event")) {
                } else if (CurrentMenu.equals("Show Seats")) {
                } else if (CurrentMenu.equals("ShowSchoolDetails")) {
                } else if (CurrentMenu.equals("Exit")) {
                    b = false;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("You will be return to Main Menu");
                CurrentMenu = "main";
            }

        }

    }
    private Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    private Employee findEmployeeById(String id) {
        for (Employee e : employees) {
            if (e.getEmployeeId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    private Classroom findClassById(String id) {
        for (Classroom c : classrooms) {
            if (c.getClassId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    private Bus findBusById(String id) {
        for (Bus b : buses) {
            if (b.getBusId().equalsIgnoreCase(id)) {
                return b;
            }
        }
        return null;
    }
    void SetTeacherList(ArrayList<Teacher>Teachers){
        this.Teachers = Teachers;
    }
    void SetSupList(ArrayList<SupportStaff>SupportStaffs){
        this.SupportStaffs = SupportStaffs;
    }
    Teacher findTeacherById(String id) {
        for(Teacher t: Teachers){
            if(t.getEmployeeId().equalsIgnoreCase(id)) {
                return t;
            }

        }
        return null;
    }


}
