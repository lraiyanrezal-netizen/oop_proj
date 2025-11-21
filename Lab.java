import java.util.ArrayList;
public class Lab {
    String LabId;
    String LabName;
    String InchargeId;
    ArrayList<LabEquipment> Equipment;
    ClassEquipment ClassEquipment;


    Lab(String LabId, String LabName, String InchargeId, ArrayList<LabEquipment> Equipment, ClassEquipment ClassEquipment) {

        this.LabId = LabId;
        this.LabName = LabName;
        this.InchargeId = InchargeId;
        this.Equipment = Equipment;
        this.ClassEquipment = ClassEquipment;
    }

    void LabDetails() {
        System.out.println("Lab ID: " + LabId);
        System.out.println("Lab Name: " + LabName);
        System.out.println("Incharge ID: " + InchargeId);
        System.out.println("Equipments of Lab : ");
        for(LabEquipment equipment : Equipment) {
            equipment.EquipmentDetails();
        }

        System.out.println("Class Equipments : ");
        ClassEquipment.EquipmentDetails();
    }


}
