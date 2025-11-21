public class Classroom {
    String ClassId;
    String ClassName;
    int StudentCount;
    ClassEquipment ClassEquipment;



    Classroom(String ClassName, String ClassId, int StudentCount, ClassEquipment ClassEquipment) {
        this.ClassId = ClassId;
        this.ClassName = ClassName;
        this.StudentCount = StudentCount;
        this.ClassEquipment = ClassEquipment;

    }

    void ClassDetails() {
        System.out.println("ClassId: " + ClassId);
        System.out.println("ClassName: " + ClassName);
        System.out.println("StudentCount: " + StudentCount);
        ClassEquipment.EquipmentDetails();
    }


    String getClassId() {
        return ClassId;
    }

}
