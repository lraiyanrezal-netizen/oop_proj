import java.util.Scanner;
import java.util.ArrayList;
public class SchoolManagement {
    String SchoolName ;
    String Address ;
    String ContactNumber;
    String MediumOfStudy;


    // ------------------------------------------------------------------ Aggregation
    private ArrayList<Employee> employees;
    ArrayList<SupportStaff>SupportStaffs;
    ArrayList <Teacher>Teachers ;
    ArrayList<Bus> buses;
    private ArrayList<Student> students;
    private Playground playground;
    // -----------------------------------------------------------Composition
    private ArrayList<Classroom> classrooms;
    private Auditorium auditorium;
    private NoticeBoard noticeBoard;
    final ArrayList<Department> departments;
    private ArrayList<Lab> labs;


    SchoolManagement(){
        // ------------------------------------------------------------------ Aggregation
        this.buses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.Teachers = new ArrayList<>();
        this.SupportStaffs = new ArrayList<>();
        this.playground = new Playground();
        // -----------------------------------------------------------Composition
        this.labs = new ArrayList<>();
        this.classrooms = new ArrayList<>();
        this.auditorium = new Auditorium();
        this.noticeBoard = new NoticeBoard();
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
                        CurrentMenu = "Notice Board";
                    } else if (c == 'F' || c=='f') {
                        CurrentMenu = "Auditorium";
                    } else if (c == 'G' || c == 'g') {
                        CurrentMenu = "Show School Details";
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
                    CurrentMenu = "Student";

                } else if (CurrentMenu.equals("Show Student Details")) {
                    System.out.println("Please enter Student ID to show student details");
                    String studentId = user.nextLine();
                    Student s = findStudentById(studentId);

                    if(s!=null){
                        s.StudentDetails();
                    } else{
                        System.out.println("Student not found");
                    }
                    CurrentMenu = "Student";
                } else if (CurrentMenu.equals("Pay Fees")) {
                    System.out.println("Please enter Student ID to pay fees");
                    String studentId = user.nextLine();
                    Student s = findStudentById(studentId);
                    if(s!=null){
                        s.PayFees();
                    }else{
                        System.out.println("Student not found");
                    }
                    CurrentMenu = "Student";

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
                    CurrentMenu = "Teacher";
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
                    CurrentMenu = "Employee";

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
                    CurrentMenu = "Support";
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
                    if (s != null && c != null) c.addStudent(s);

                    CurrentMenu = "Class";
                } else if (CurrentMenu.equals("Assign Teacher")) {
                    System.out.println("Please enter Teacher ID to assign teacher");
                    String teacherId = user.nextLine();
                    Teacher t = findTeacherById(teacherId);
                    System.out.println("Please enter Class ID to assign teacher");
                    String classId = user.nextLine();
                    Classroom c = findClassById(classId);
                    if(t != null && c!=null) c.AssignTeacher(t);
                    CurrentMenu = "Class";
                } else if (CurrentMenu.equals("Show Details")) {
                    System.out.println("Please enter Class ID to Show Details");
                    String ClassID = user.nextLine();
                    Classroom C = findClassById(ClassID);
                    if(C != null) C.ClassDetails();
                    CurrentMenu = "Class";
                } else if (CurrentMenu.equals("Notice Board")) {
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
                    noticeBoard.display();

                    CurrentMenu = "NoticeBoard";
                } else if (CurrentMenu.equals("Add Content")) {
                    System.out.println("Please enter Content to add it");
                    String content = user.nextLine();
                    noticeBoard.addContent(content);
                    CurrentMenu = "NoticeBoard";
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
                        CurrentMenu = "Show Seats1";
                    } else if (c1 == 'D' || c1=='d') {
                        CurrentMenu = "main";
                    }
                } else if (CurrentMenu.equals("Book Auditorium")) {
                    System.out.println("Please enter event Name");
                    String eventName = user.nextLine();
                    System.out.println("Please enter event time");
                    String eventTime = user.nextLine();
                    System.out.println("Please enter event date");
                    String eventDate = user.nextLine();
                    System.out.println("Please enter Seats Occupied ");
                    int SeatsOccupied = user.nextInt();
                    user.nextLine();
                    auditorium.BookAuditorium(SeatsOccupied, eventName, eventDate, eventTime);
                    CurrentMenu = "Auditorium";
                } else if (CurrentMenu.equals("Show Event Details")) {
                    auditorium.EventDetails();
                    CurrentMenu = "Auditorium";
                } else if (CurrentMenu.equals("Show Seats1")) {
                    auditorium.DisplaySeats();
                    CurrentMenu = "Auditorium";
                } else if (CurrentMenu.equals("Show School Details")) {
                    this.ShowSchoolDetails();

                    CurrentMenu = "main";
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

    void ShowSchoolDetails() {
        System.out.println("-------School Details---------");
        String schoolName = this.SchoolName;
        System.out.println("School Name: \n" + schoolName);
        String schoolAddress = this.Address;
        System.out.println("School Address: \n" + schoolAddress);
        String mediumOfStudy = this.MediumOfStudy;
        System.out.println("Medium Of Study: \n" + mediumOfStudy);
        String ContactNumber = this.ContactNumber;
        System.out.println("Contact Number: \n" + ContactNumber);

    }


    // Getters
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
    Teacher findTeacherById(String id) {
        for(Teacher t: Teachers){
            if(t.getEmployeeId().equalsIgnoreCase(id)) {
                return t;
            }

        }
        return null;
    }


    // Setters
    void SetTeacherList(ArrayList<Teacher>Teachers){
        this.Teachers = Teachers;
    }
    void SetSupList(ArrayList<SupportStaff>SupportStaffs){
        this.SupportStaffs = SupportStaffs;
    }

    void SetClassrooms(ArrayList<Classroom>Classrooms){
        this.classrooms = Classrooms;
    }
    void SetLabs(ArrayList<Lab>Labs){
        this.labs = Labs;
    }
    void SetEmployers(ArrayList<Employee>Employers){
        this.employees = Employers;
    }
    void SetPlayground(Playground Playground){
        this.playground = Playground;
    }
    void SetAuditorium(Auditorium auditorium){
        this.auditorium = auditorium;
    }
    void SetNoticeBoard(NoticeBoard noticeBoard){
        this.noticeBoard = noticeBoard;

    }
    void AddDepartment(Department department){
        departments.add(department);
    }
    void AddClassroom(Classroom classroom){
        classrooms.add(classroom);
    }
    void AddLabRoom(Lab lab){
        labs.add(lab);
    }


}
