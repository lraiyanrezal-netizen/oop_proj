import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

            Scanner user = new Scanner(System.in);
            System.out.println("Welcome to School Management System\nCreate new school");
            System.out.println("Enter the name of the school:");
            String SchoolName = user.nextLine();
            System.out.println("Enter the address of school:");
            String Address = user.nextLine();
            System.out.println("Enter the contact number of school:");
            String ContactNumber = user.nextLine();
            System.out.println("Enter the medium of study in school:");
            String MediumOfStudy = user.nextLine();

            SchoolManagement School = new SchoolManagement(SchoolName, Address, ContactNumber, MediumOfStudy);


            System.out.println("Enter the the seats number of auditorium:");
            int totalSeats = user.nextInt();
            user.nextLine();
            Auditorium auditorium = new Auditorium(totalSeats);


            System.out.println("Enter the area of the playground:");
            double area = user.nextDouble();
            user.nextLine();
            Playground playground = new Playground(area);


            ArrayList<Classroom> classrooms = new ArrayList<>();
            System.out.println("Enter the number of Classrooms:");
            int NumberOfClassrooms = user.nextInt();
            user.nextLine();
            for (int i = 0; i < NumberOfClassrooms; i++) {
                String ClassId = "C" + (i + 1);
                System.out.println("Enter the name of the Classroom " + (i + 1) + ":");
                String ClassName = user.nextLine();
                System.out.println("Enter the count of student in Classroom:");
                int CountOfStudent = user.nextInt();
                user.nextLine();


                System.out.println("Enter the count of bench: ");
                int CountOfBenchmark = user.nextInt();
                user.nextLine();
                System.out.println("Enter the count of fan:");
                int CountOfFan = user.nextInt();
                user.nextLine();
                System.out.println("Enter the count of light:");
                int CountOfLight = user.nextInt();
                user.nextLine();

                Classroom Classroom = new Classroom(ClassName, ClassId, CountOfStudent, new ClassEquipment(ClassId,CountOfBenchmark,CountOfFan,CountOfLight));
                classrooms.add(Classroom);
            }


            ArrayList<Lab> Labs = new ArrayList<>();
            System.out.println("Enter the number of Labs:");
            int NumberOfLabs = user.nextInt();
            user.nextLine();


            for (int i = 0; i < NumberOfLabs; i++) {
                String LabId = "L" + (i + 1);
                System.out.println("Enter the name of the Lab:");
                String LabName = user.nextLine();
                System.out.println("Enter Incharge ID:");
                String InchargeID = user.nextLine();
                System.out.println("Enter the count of Equipments in Lab:");
                int CountOfEquipments = user.nextInt();
                user.nextLine();





            ArrayList<LabEquipment> labEquipmentsList = new ArrayList<>();
            for(int j = 0 ; j < CountOfEquipments ; j++){
                String EquipmentId = "E" + (j+1);
                System.out.println("Enter the name of the Equipment :");
                String EquipName = user.nextLine();
                System.out.println("Enter the count of equipment:");
                int CountOfEquipment = user.nextInt();
                System.out.println("Enter the cost of equipment:");
                double CostOfEquipment = user.nextDouble();
                user.nextLine();



                labEquipmentsList.add(new LabEquipment(EquipName,CountOfEquipment, EquipmentId,CostOfEquipment ));
            }


                System.out.println("Enter the count of bench:");
                int CountOfBenchmark1 = user.nextInt();
                user.nextLine();
                System.out.println("Enter the count of fan:");
                int CountOfFan1 = user.nextInt();
                user.nextLine();
                System.out.println("Enter the count of light:");
                int CountOfLight1 = user.nextInt();
                user.nextLine();


                Lab lab = new Lab(LabId, LabName, InchargeID, labEquipmentsList, new ClassEquipment(LabId, CountOfBenchmark1, CountOfFan1, CountOfLight1));
                Labs.add(lab);



            }

            ArrayList<Employee> Employees = new ArrayList<>();

            System.out.println("Enter Number of teacher: ");
            int NumberOfTeachers = user.nextInt();
            user.nextLine();
            for (int i = 0; i < NumberOfTeachers; i++) {
                String TeacherId = "T" + (i + 1);
                System.out.println("Enter the name of the Teacher:");
                String TeacherName = user.nextLine();
                System.out.println("Enter the Salary of Teacher:");
                double SalaryOfTeacher = user.nextDouble();
                user.nextLine();
                System.out.println("Enter Department ID of the Teacher:");
                String DepartmentID = user.nextLine();
                Employees.add(new Teacher(TeacherId, TeacherName, SalaryOfTeacher, DepartmentID));
            }
            System.out.println("Enter the number of Support Staff: ");
            int NumberOfStaff = user.nextInt();
            user.nextLine();
            for (int i = 0; i < NumberOfStaff; i++) {
                String StaffId = "S" + (i + 1);
                System.out.println("Enter the name of the Staff:");
                String StaffName = user.nextLine();
                System.out.println("Enter the Salary of Staff:");
                double SalaryOfStaff = user.nextDouble();
                user.nextLine();
                System.out.println("Enter Department ID of the Staff:");
                String DepartmentID = user.nextLine();
                Employees.add(new SupportStaff(StaffId, StaffName, SalaryOfStaff, DepartmentID));
            }
            School.RunSchool();



    }
}
