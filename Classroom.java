import java.util.ArrayList;

public class Classroom {
    String ClassId;
    String ClassName;
    int StudentCount;
    ClassEquipment ClassEquipment;
    ArrayList<Student> Students;
    Teacher Teacher;



    Classroom(String ClassName, String ClassId, int StudentCount, ClassEquipment ClassEquipment) {
        this.ClassId = ClassId;
        this.ClassName = ClassName;
        this.StudentCount = StudentCount;
        this.ClassEquipment = ClassEquipment;
        Students = new ArrayList<>();

    }

    void ClassDetails() {
        System.out.println("ClassId: " + ClassId);
        System.out.println("ClassName: " + ClassName);
        System.out.println("StudentCount: " + StudentCount);
        ClassEquipment.EquipmentDetails();
    }
    void AssignTeacher(Teacher Teacher) {
        this.Teacher = Teacher;
    }

    void addStudent(Student student) {
        if (Students.size() < StudentCount && !Students.contains(student)) {
            Students.add(student);
        }else{
            System.out.println("Student already exists or now capacity exceeded");
        }
    }


    String getClassId() {
        return ClassId;
    }

}
