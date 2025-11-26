import java.util.ArrayList;
public class Bus {

    String BusId;
    String DriverId;
    ArrayList<String> AreaList;
    int BusNumber;
    int Capacity;
    ArrayList <Student> Students;

    Bus(String BusId, String DriverId, ArrayList<String> AreaList, int Capacity,ArrayList <Student> Students) {
        this.BusId = BusId;
        this.DriverId = DriverId;
        this.AreaList = AreaList;
        this.Capacity = Capacity;
        this.Students = Students;
    }

    String getBusId() {
        return BusId;
    }

    void BusDetails() {
        System.out.println("Bus Details");
        System.out.println("BusId: " + BusId);
        System.out.println("DriverId: " + DriverId);
        System.out.println("AreaList: " + AreaList);
        System.out.println("BusNumber: " + BusNumber);
        System.out.println("Capacity: " + Capacity);
    }

    void ShowSeats(){
        System.out.println("Available Seats:");
        System.out.println(Capacity-Students.size());
    }

}
