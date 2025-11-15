import java.util.Scanner;
import java.util.ArrayList;
public class SchoolManagement {
    String SchoolName ;
    String Address ;
    String ContactNumber;
    String MediumOfStudy;
    SchoolManagement(String SchoolName, String Address, String ContactNumber, String MediumOfStudy) {
        this.SchoolName = SchoolName;
        this.Address = Address;
        this.ContactNumber = ContactNumber;
        this.MediumOfStudy = MediumOfStudy;
    }
    void RunSchool(){
        boolean b = true;
        String CurrentMenu = "main";
        Scanner user = new Scanner(System.in);
        while(b){
            if (CurrentMenu.equals("main")) {
                System.out.println("Choose an option: ");
                System.out.println("A- Bus");
                System.out.println("B- Student");
                System.out.println("C- Employee");
                System.out.println("D- Class");
                System.out.println("E- NoticeBoard");
                System.out.println("F- Audotorium");
                System.out.println("G- ShowSchoolDetails");
                System.out.println("H- Exit");
            }

            char c = user.next().charAt(0);

            switch(c) {
                case 'A': CurrentMenu = "Bus";break;
                case 'B': CurrentMenu = "Student";break;
                case 'C': CurrentMenu = "Employee";break;
                case 'D': CurrentMenu = "Class";break;
                case 'E': CurrentMenu = "NoticeBoard";break;
                case 'F': CurrentMenu = "Audotorium";break;
                case 'G': CurrentMenu = "ShowSchoolDetails";break;
                case 'H': CurrentMenu = "Exit";break;
                default: CurrentMenu = "None";break;


            }
            if (CurrentMenu.equals("Bus")) {

            }else if (CurrentMenu.equals("Student")) {
                System.out.println("Choose an option: ");
                System.out.println("A- Add Student");
                System.out.println("B- Show Student Details");
                System.out.println("C- Pay Fees");
                System.out.println("D- Go Back");

                char c1 = user.next().charAt(0);

                switch(c1) {
                    case 'A': CurrentMenu = "Add Student"; break;
                    case 'B': CurrentMenu = "Show Student Details";break;
                    case 'C': CurrentMenu = "Pay Fees"; break;
                    case 'D': CurrentMenu = "main"; break;

                }


            }else if (CurrentMenu.equals("Add Student")) {

            }else if (CurrentMenu.equals("Show Student Details")) {

            }else if (CurrentMenu.equals("Pay Fees")) {

            } else if (CurrentMenu.equals("Employee")) {

            }else if (CurrentMenu.equals("Class")) {

            }else if (CurrentMenu.equals("NoticeBoard")) {

            }else if (CurrentMenu.equals("Audotorium")) {

            }else if (CurrentMenu.equals("ShowSchoolDetails")) {

            }else if (CurrentMenu.equals("Exit")) {
                b = false;
            }


        }
    }
}
