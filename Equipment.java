public abstract class Equipment {
    String EquipmentId;
    protected double Cost;
    Equipment(){}
    Equipment(String EquipmentId, double Cost) {
        this.EquipmentId = EquipmentId;
        this.Cost = Cost;
    }

    public abstract void EquipmentDetails();
    String getEquipmentId() {
        return EquipmentId;
    }

    void PurchaseEquipment(){
        System.out.println("Equipment: " + EquipmentId + " Purchased with Cost: " + Cost );
    }
    void repairEquipment(){
        System.out.println("Equipment: " + EquipmentId + " has been Repaired");
    }

}
class ClassEquipment extends Equipment {
    private String ClassId;
    private int benchCount;
    private int fanCount;
    private int lightCount;

    public void EquipmentDetails(){
        System.out.println("Class: " + ClassId);
        System.out.println("Bench Count: " + benchCount);
        System.out.println("Fan Count: " + fanCount);
        System.out.println("Light Count: " + lightCount);
    }

    ClassEquipment(String ClassId, int BenchCount, int FanCount, int LightCount) {
        this.ClassId = ClassId;
        this.benchCount = BenchCount;
        this.fanCount = FanCount;
        this.lightCount = LightCount;
    }
}
class LabEquipment extends Equipment {
    private String EquipmentName;
    private int EquipmentCount;

    public void EquipmentDetails(){
        System.out.println("Lab: " + EquipmentName);
        System.out.println("Lab Count: " + EquipmentCount);
    }

    LabEquipment(String EquipmentName, int EquipmentCount,String EquipmentId, double Cost ){
        super(EquipmentId, Cost);

        this.EquipmentName = EquipmentName;
        this.EquipmentCount = EquipmentCount;
    }
}