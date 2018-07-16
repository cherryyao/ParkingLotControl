import com.thoughtworks.tdd.ParkingBoy;
import com.thoughtworks.tdd.ParkingLot;
import controller.LotsMangeController;
import controller.ManageController;
import controller.ParkingboyController;
import view.Cli;
import view.Request;
import view.Response;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotMangeMain {
    public static void main(String[] args){
        Request request = new Request();
        Response response = new Response();

        ParkingLot parkingLot1 =new ParkingLot("001", "西南停车场", 28);
        ParkingLot parkingLot2 =new ParkingLot("002", "西南停车场", 12);
        List<ParkingLot> ParkingLotList = new ArrayList<>();
        ParkingLotList.add(parkingLot1);
        ParkingLotList.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);
        LotsMangeController lotsController =new LotsMangeController();
        ManageController manageController = new ManageController();
        ParkingboyController parkingboyController = new ParkingboyController(parkingBoy);
        LotsRoute router = new LotsRoute("manageMain",parkingboyController,lotsController,manageController);

        manageController.showMainPage();


        Cli cli = new Cli();

        while(true){
            String readCommand = cli.read();
            request.setParameter(readCommand);
            router.handleRequest(request);

        }
    }
}
