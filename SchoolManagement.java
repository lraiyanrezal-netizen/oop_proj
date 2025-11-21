import java.util.Scanner;
import java.util.ArrayList;
public class SchoolManagement {
    String SchoolName ;
    String Address ;
    String ContactNumber;
    String MediumOfStudy;

    private Auditorium auditorium;
    private Playground playground;
    private NoticeBoard noticeBoard;
    private ArrayList<Employee> employees;
    private ArrayList<Classroom> classrooms;
    private ArrayList<Lab> labs;
    private ArrayList<Department> departments;
     ArrayList<Bus> buses;
    private ArrayList<Student> students;

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


                    if (c == 'A') {
                        CurrentMenu = "Bus";
                    } else if (c == 'B') {
                        CurrentMenu = "Student";
                    } else if (c == 'C') {
                        CurrentMenu = "Employee";
                    } else if (c == 'D') {
                        CurrentMenu = "Class";
                    } else if (c == 'E') {
                        CurrentMenu = "NoticeBoard";
                    } else if (c == 'F') {
                        CurrentMenu = "Auditorium";
                    } else if (c == 'G') {
                        CurrentMenu = "ShowSchoolDetails";
                    } else if (c == 'H') {
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


                    if (c == 'A') {
                        CurrentMenu = "Add Bus";
                    } else if (c == 'B') {
                        CurrentMenu = "Show bus details";
                    } else if (c == 'C') {
                        CurrentMenu = "Show Seats";
                    } else if (c == 'D') {
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

                        if (cc == 'A') {
                            StudentList.add(new PrimaryStudent(studentId));

                        } else if (cc == 'B') {
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


                    if (c1 == 'A') {
                        CurrentMenu = "Add Student";
                    } else if (c1 == 'B') {
                        CurrentMenu = "Show Student Details";
                    } else if (c1 == 'C') {
                        CurrentMenu = "Pay Fees";
                    } else if (c1 == 'D') {
                        CurrentMenu = "main";
                    }
                } else if (CurrentMenu.equals("Add Student")) {
                } else if (CurrentMenu.equals("Show Student Details")) {
                } else if (CurrentMenu.equals("Pay Fees")) {
                } else if (CurrentMenu.equals("Employee")) {
                    System.out.println("---------Employee Menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Teacher");
                    System.out.println("B- Support Staff");
                    System.out.println("C- main");

                    char c1 = user.nextLine().charAt(0);


                    if (c1 == 'A') {
                        CurrentMenu = "Teacher";
                    } else if (c1 == 'B') {
                        CurrentMenu = "Support";
                    } else if (c1 == 'C') {
                        CurrentMenu = "main";
                    }
                } else if (CurrentMenu.equals("Teacher")) {
                } else if (CurrentMenu.equals("Support")) {
                } else if (CurrentMenu.equals("Class")) {
                    System.out.println("---------Class Menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- AddStudent");
                    System.out.println("B- Assign Teacher");
                    System.out.println("C- Show Details");
                    System.out.println("D- Go Back");

                    char c1 = user.nextLine().charAt(0);


                    if (c1 == 'A') {
                        CurrentMenu = "Add_Student";
                    } else if (c1 == 'B') {
                        CurrentMenu = "Assign Teacher";
                    } else if (c1 == 'C') {
                        CurrentMenu = "Show Details";
                    } else if (c1 == 'D') {
                        CurrentMenu = "main";
                    }
                } else if (CurrentMenu.equals("Add_Student")) {
                } else if (CurrentMenu.equals("Assign Teacher")) {
                } else if (CurrentMenu.equals("Show Details")) {
                } else if (CurrentMenu.equals("NoticeBoard")) {
                    System.out.println("---------NoticeBoard Menu---------");
                    System.out.println("Choose an option: ");
                    System.out.println("A- Display");
                    System.out.println("B- Add Content");
                    System.out.println("C- Go Back");
                    char c1 = user.nextLine().charAt(0);

                    if (c1 == 'A') {
                        CurrentMenu = "Display";
                    } else if (c1 == 'B') {
                        CurrentMenu = "Add Content";
                    } else if (c1 == 'C') {
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

                    if (c1 == 'A') {
                        CurrentMenu = "Book Auditorium";
                    } else if (c1 == 'B') {
                        CurrentMenu = "Show Event Details";
                    } else if (c1 == 'C') {
                        CurrentMenu = "Show Seats";
                    } else if (c1 == 'D') {
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
}
