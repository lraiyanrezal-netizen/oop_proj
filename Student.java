import java.util.ArrayList;

abstract class Student {
    String StudentID;
    String StudentName;
    String ClassId;
    int Section;
    String BusId;

    ArrayList<HigherSecondaryStudent> HigherSecondaryStudents;
    ArrayList<PrimaryStudent>PrimaryStudents;
    static int StudentsCount;
    Student(String StudentID){
        this.StudentID = StudentID;
        StudentsCount++;
    }

    Student(String studentID, String studentName, String classId, int section, String busId) {
        StudentID = studentID;
        StudentName = studentName;
        ClassId = classId;
        Section = section;
        BusId = busId;
        StudentsCount++;

    }

    String getStudentId() {
        return StudentID;
    }



    abstract void StudentDetails();

    void PayFees(){
        System.out.println(this.StudentName+" Paid fees");
    }

}
class PrimaryStudent extends Student {
    PrimaryStudent(String studentID, String studentName, String classId, int section, String busId) {
        super(studentID, studentName, classId, section, busId);
        PrimaryStudents = new ArrayList<>();
        PrimaryStudents.add(this);
    }
    PrimaryStudent(String studentID) {
        super(studentID);
        PrimaryStudents = new ArrayList<>();
        PrimaryStudents.add(this);

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
        HigherSecondaryStudents.add(this);
    }
    HigherSecondaryStudent(String studentID) {
        super(studentID);
        HigherSecondaryStudents = new ArrayList();
        HigherSecondaryStudents.add(this);
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
