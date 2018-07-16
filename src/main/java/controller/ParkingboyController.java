package controller;

import com.thoughtworks.tdd.*;
import view.Request;
import view.Response;

import java.util.UUID;

public class ParkingboyController {
   private ParkingBoy parkingBoy;
   private Response response =new Response();

    public ParkingboyController(ParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public void park(String inputs) {

        if(parkingBoy.isParking()){
            Car car = new Car(inputs);
            Receipt receipt = parkingBoy.parking(car);
            response.send("停车成功，您的小票是："+receipt.getUUID()+"\n");
            showMainPage();

        }else{
            throw new ParkingLotFullException();
        }
    }

    public void unPark(String  inputRecipit) {
        try{
            Receipt receipt = new Receipt(UUID.fromString(inputRecipit));
            Car car = parkingBoy.pickCar(receipt);
             response.send("车已取出，您的车牌号是: " +car.getId()+"\n");
            showMainPage();
        }catch (Exception e){
            throw new UnparkExcepiton();
        }
    }

    public boolean isParking(){
        return parkingBoy.isParking();
    }

    public void showMainPage() {
        response.send("1.停车\n" + "2.取车\n" + "请输入您要进行的操作:\n");
    }
    public String mainPage(Request request){
       String currentPage = "main";
        switch (request.getParameter()){

            case "1":
                if (isParking()){
                    response.send("请输入车牌号：");
                    currentPage="park";
                }else {
                    response.send("车已停满，请晚点再来");
                    currentPage="main";
                }
                break;
            case "2":
                currentPage = "unpark";
                response.send("请输入小票编号：");
                break;
            default:
                response.send("非法指令，请查证后再输\n");
                showMainPage();

        }
        return currentPage;
    }
}
