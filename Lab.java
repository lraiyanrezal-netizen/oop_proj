import java.util.ArrayList;
public class Lab {
    String LabId;
    String LabName;
    String InchargeId;
    ArrayList <LabEquipment> Equipments;
    ClassEquipment ClassEquipment;
    String EquipmentId;


    Lab(String LabId, String LabName, String InchargeId,ClassEquipment ClassEquipment) {

        this.LabId = LabId;
        this.LabName = LabName;
        this.InchargeId = InchargeId;
        this.ClassEquipment = ClassEquipment;
        ArrayList <LabEquipment> Equipments = new ArrayList<>();

    }
}
