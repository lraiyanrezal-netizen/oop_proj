import java.util.ArrayList;

public abstract class Student {
    String StudentID;
    String StudentName;
    String ClassId; // <----------------------------------------------- Association
    int Section;
    String BusId;// <----------------------------------------------- Association
    boolean isPaid;

    // ------------------------------------------------------------------ Aggregation
    Teacher Teacher;

    ArrayList<HigherSecondaryStudent> HigherSecondaryStudents;
    ArrayList<PrimaryStudent>PrimaryStudents;
    static int StudentsCount;
    Student(String StudentID){
        this.StudentID = StudentID;
        StudentsCount++;
        isPaid = false;
    }

    Student(String studentID, String studentName, String classId, int section, String busId) {
        StudentID = studentID;
        StudentName = studentName;
        ClassId = classId;
        Section = section;
        BusId = busId;
        StudentsCount++;
        isPaid = false;

    }

    String getStudentId() {
        return StudentID;
    }



    abstract void StudentDetails();

    void PayFees(){
        System.out.println(this.StudentName+" Paid fees");
        isPaid = true;
    }

}
class PrimaryStudent extends Student {
    PrimaryStudent(String studentID, String studentName, String classId, int section, String busId) {
        super(studentID, studentName, classId, section, busId);

        isPaid = false;
    }
    PrimaryStudent(String studentID) {
        super(studentID);


        isPaid = false;

    }

    void StudentDetails(){
        System.out.println("Primary Student details");
        System.out.println("Student ID: " + this.StudentID);
        System.out.println("Student Name: " + this.StudentName);
        System.out.println("Class ID: " + this.ClassId);
        System.out.println("Section: " + this.Section);
        System.out.println("Bus ID: " + this.BusId);
    }


}
class HigherSecondaryStudent extends Student {
    HigherSecondaryStudent(String studentID, String studentName, String classId, int section, String busId) {
        super(studentID, studentName, classId, section, busId);
        HigherSecondaryStudents = new ArrayList();
        isPaid = false;
    }
    HigherSecondaryStudent(String studentID) {
        super(studentID);
        HigherSecondaryStudents.add(this);
        isPaid = false;
    }
    void StudentDetails(){
        System.out.println("Higher Secondary Student details");
        System.out.println("Student ID: " + this.StudentID);
        System.out.println("Student Name: " + this.StudentName);
        System.out.println("Class ID: " + this.ClassId);
        System.out.println("Section: " + this.Section);
        System.out.println("Bus ID: " + this.BusId);
    }

}
