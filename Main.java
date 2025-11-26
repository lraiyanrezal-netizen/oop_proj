import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        boolean b = true;
        String SchoolName;
        String MediumOfStudy;
        String ContactNumber;
        String Address;
        SchoolManagement School = new SchoolManagement();

        while (b) {
            try {
                System.out.println("Welcome to School Management System\nCreate new school");
                System.out.println("Enter the name of the school:");
                SchoolName = user.nextLine();
                School.SchoolName = SchoolName;
                System.out.println("Enter the address of school:");
                Address = user.nextLine();
                School.Address = Address;
                System.out.println("Enter the contact number of school:");
                ContactNumber = user.nextLine();
                School.ContactNumber = ContactNumber;
                System.out.println("Enter the medium of study in school:");
                MediumOfStudy = user.nextLine();
                School.MediumOfStudy = MediumOfStudy;
                b = false;

            }catch(InputMismatchException e){
                System.out.println("There is an Error in Input");
                System.out.println("Input again");

            }
        }

        int totalSeats = 0;
        b = true;
        while (b){
            try {
                System.out.println("Enter the the seats number of auditorium:");
                totalSeats = user.nextInt();
                user.nextLine();
                b = false;
            }catch(InputMismatchException e){
                System.out.println("There is an Error in Input");
                user.nextLine();
                System.out.println("\nInput Again");
            }
        }


        Playground  playground = new Playground();
        double area = 0;
        b = true;
        while (b){
            try {
                System.out.println("Enter the area of the playground:");
                area = user.nextDouble();
                user.nextLine();
                playground.area = area;
                b = false;
            }catch(InputMismatchException e){
                System.out.println("There is an Error in Input");
                user.nextLine();
                System.out.println("\nInput Again");
            }
        }



        int NumberOfClassrooms = 0;
        b = true;
        while (b){
            try {
                System.out.println("Enter the number of Classrooms:");
                NumberOfClassrooms = user.nextInt();
                user.nextLine();
                b = false;
            }catch(InputMismatchException e){
                System.out.println("There is an Error in Input");
                user.nextLine();
                System.out.println("\nInput Again");
            }

        }
        for (int i = 0; i < NumberOfClassrooms; i++) {
            String ClassId ="";
            String ClassName ="";
            int CountOfStudent = 0;
            int CountOfBenchmark = 0;
            int CountOfFan = 0 ;
            int CountOfLight = 0;
            b = true;
            while (b){

                try {
                    ClassId = "C" + (i + 1);
                    System.out.println("Enter the name of the Classroom " + (i + 1) + ":");
                    ClassName = user.nextLine();
                    System.out.println("Enter the count of student in Classroom:");
                    CountOfStudent = user.nextInt();
                    user.nextLine();


                    System.out.println("Enter the count of bench: ");
                    CountOfBenchmark = user.nextInt();
                    user.nextLine();
                    System.out.println("Enter the count of fan:");
                    CountOfFan = user.nextInt();
                    user.nextLine();
                    System.out.println("Enter the count of light:");
                    CountOfLight = user.nextInt();
                    user.nextLine();
                    b = false;
                }catch(InputMismatchException e){
                    System.out.println("There is an Error in Input");
                    user.nextLine();
                    System.out.println("\nInput Again");
                }
            }

            // -----------------------------------------------------------Composition
            // Composition Classroom and class Equipment
            // Composition School and Classrooms

            School.AddClassroom(new Classroom(ClassName, ClassId, CountOfStudent, new ClassEquipment(ClassId,CountOfBenchmark,CountOfFan,CountOfLight)));
        }



        int NumberOfLabs=0;
        b = true;
        while (b){
            try{
                System.out.println("Enter the number of Labs:");
                NumberOfLabs = user.nextInt();
                user.nextLine();
                b = false;
            }catch(InputMismatchException e){
                System.out.println("There is an Error in Input");
                user.nextLine();
                System.out.println("\nInput Again");
            }
        }


        for (int i = 0; i < NumberOfLabs; i++) {
            String LabId ="";
            String LabName ="";
            String InchargeID ="";
            int CountOfEquipments = 0;
            b = true;
            while (b){
                try {
                    LabId = "L" + (i + 1);
                    System.out.println("Enter the name of the Lab:");
                    LabName = user.nextLine();
                    System.out.println("Enter Incharge ID:");
                    InchargeID = user.nextLine();
                    System.out.println("Enter the count of Equipments in Lab:");
                    CountOfEquipments = user.nextInt();
                    user.nextLine();
                    b = false;
                }catch(InputMismatchException e){
                    System.out.println("There is an Error in Input");
                    user.nextLine();
                    System.out.println("\nInput Again");
                }
            }





            ArrayList<LabEquipment> labEquipmentsList = new ArrayList<>();
            for(int j = 0 ; j < CountOfEquipments ; j++){
                String EquipmentId = "";
                String EquipName ="";
                int CountOfEquipment = 0;
                double CostOfEquipment =0;
                b = true;
                while (b){
                    try {
                        EquipmentId = "E" + (j + 1);
                        System.out.println("Enter the name of the Equipment :");
                        EquipName = user.nextLine();
                        System.out.println("Enter the count of equipment:");
                        CountOfEquipment = user.nextInt();
                        System.out.println("Enter the cost of equipment:");
                        CostOfEquipment = user.nextDouble();
                        user.nextLine();
                        b = false;
                    }catch(InputMismatchException e){
                        System.out.println("There is an Error in Input");
                        user.nextLine();
                        System.out.println("\nInput Again");
                    }
                }

                labEquipmentsList.add(new LabEquipment(EquipName,CountOfEquipment, EquipmentId,CostOfEquipment ));
            }


            int CountOfBenchmark1 = 0;
            int CountOfFan1 = 0 ;
            int CountOfLight1 = 0;
            b = true;
            while (b){
                try {
                    System.out.println("Enter the count of bench:");
                    CountOfBenchmark1 = user.nextInt();
                    user.nextLine();
                    System.out.println("Enter the count of fan:");
                    CountOfFan1 = user.nextInt();
                    user.nextLine();
                    System.out.println("Enter the count of light:");
                    CountOfLight1 = user.nextInt();
                    user.nextLine();
                    b = false;
                }catch(InputMismatchException e){
                    System.out.println("There is an Error in Input");
                    user.nextLine();
                    System.out.println("\nInput Again");
                }
            }
            // -----------------------------------------------------------Composition
            School.AddLabRoom(new Lab(LabId, LabName, InchargeID, labEquipmentsList, new ClassEquipment(LabId, CountOfBenchmark1, CountOfFan1, CountOfLight1)));
        }

        ArrayList<Employee> Employees = new ArrayList<>();
        ArrayList<Teacher> Teachers = new ArrayList<>();
        ArrayList<SupportStaff> SupportStaffs = new ArrayList<>();
        int NumberOfTeachers = 0;
        b = true;
        while (b){
            try {
                System.out.println("Enter Number of teacher: ");
                NumberOfTeachers = user.nextInt();
                user.nextLine();
                b = false;
            }catch(InputMismatchException e){
                System.out.println("There is an Error in Input");
                user.nextLine();
                System.out.println("\nInput Again");
            }
        }

        for (int i = 0; i < NumberOfTeachers; i++) {
            String TeacherId = "";
            String TeacherName ="";
            double SalaryOfTeacher = 0;
            String DepartmentID = "";
            b = true;
            while (b){
                try {
                    TeacherId = "T" + (i + 1);
                    System.out.println("Enter the name of the Teacher:");
                    TeacherName = user.nextLine();
                    System.out.println("Enter the Salary of Teacher:");
                    SalaryOfTeacher = user.nextDouble();
                    user.nextLine();
                    System.out.println("Enter Department ID of the Teacher:");
                    DepartmentID = user.nextLine();
                    b = false;
                }catch(InputMismatchException e){
                    System.out.println("There is an Error in Input");
                    user.nextLine();
                    System.out.println("\nInput Again");
                }
            }


            Teacher T = new Teacher(TeacherId, TeacherName, SalaryOfTeacher, DepartmentID);

            Employees.add(T);
            Teachers.add(T);
        }
        int NumberOfStaff =0;
        b = true;
        while (b){
            try {
                System.out.println("Enter the number of Support Staff: ");
                NumberOfStaff = user.nextInt();
                user.nextLine();
                b = false;
            }catch(InputMismatchException e){
                System.out.println("There is an Error in Input");
                user.nextLine();
                System.out.println("\nInput Again");
            }
        }
        for (int i = 0; i < NumberOfStaff; i++) {
            String StaffId ="";
            String StaffName ="";
            double SalaryOfStaff = 0;
            String DepartmentID = "";
            b = true;
            while (b){
                try {
                    StaffId = "S" + (i + 1);
                    System.out.println("Enter the name of the Staff:");
                    StaffName = user.nextLine();
                    System.out.println("Enter the Salary of Staff:");
                    SalaryOfStaff = user.nextDouble();
                    user.nextLine();
                    System.out.println("Enter Department ID of the Staff:");
                    DepartmentID = user.nextLine();
                    b = false;
                }catch(InputMismatchException e){
                    System.out.println("There is an Error in Input");
                    user.nextLine();
                    System.out.println("\nInput Again");
                }
            }
            SupportStaff S = new SupportStaff(StaffId, StaffName, SalaryOfStaff, DepartmentID);
            Employees.add(S);
            SupportStaffs.add(S);
        }
        ArrayList<Teacher> IT = new ArrayList<>();
        IT.add(School.findTeacherById("T1"));
        IT.add(School.findTeacherById("T2"));
        IT.add(School.findTeacherById("T5"));
        IT.add(School.findTeacherById("T8"));
        ArrayList<Teacher> DS = new ArrayList<>();
        DS.add(School.findTeacherById("T3"));
        DS.add(School.findTeacherById("T7"));
        ArrayList<Teacher> CS = new ArrayList<>();
        CS.add(School.findTeacherById("T4"));
        CS.add(School.findTeacherById("T6"));

        // -----------------------------------------------------------Composition
        //Init Departments
        School.AddDepartment(new Department("D1", "IT", "Mohammed Ismail", IT)) ;
        School.AddDepartment(new Department("D2", "DS", "Mohammed Ali", DS)) ;
        School.AddDepartment(new Department("D3", "CS", "Mohammed Ahmad", CS));

        
        
        // ------------------------------------------------------------------ Aggregation
        // Init in school management Sys
        School.SetEmployers(Employees);
        School.SetSupList(SupportStaffs);
        School.SetTeacherList(Teachers);
        School.SetPlayground(playground);


        // -----------------------------------------------------------Composition
        School.SetNoticeBoard(new NoticeBoard("Ismail Naser"));
        School.SetAuditorium(new Auditorium(totalSeats));
        School.RunSchool();



    }
}