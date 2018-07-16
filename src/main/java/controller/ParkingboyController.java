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
    public Receipt park(String carID){
        Car car =new Car(carID);
        return parkingBoy.parking(car);
    }
    public void parkPage(String inputs){
        if (parkingBoy.isParking()){
            Receipt receipt = park(inputs);
            response.send("\n停车成功，您的小票是："+receipt.getUUID());
        }
    }

    public Car unpark(String parameter){
        return parkingBoy.pickCar(new Receipt(UUID.fromString(parameter)));
    }
    public void unparkPage(Request request) {
        try {
            Car car = unpark(request.getParameter());
            response.send("\n车已取出，您的车牌号是:"+ car.getId());
        } catch (RuntimeException exception) {
            response.send("\n非法小票，无法取出车，请查证后再输");
        }
        response.send("\n1.停车服务\n" + "2.停车场管理\n" + "请输入您要进入的页面：");
    }

    public boolean isParking(){
        return parkingBoy.isParking();
    }

    public void showMainPage() {
        response.send("\n1.停车\n" + "2.取车\n" + "请输入您要进行的操作:");
    }

    public String mainPage(Request request){
       String currentPage = "main";
        switch (request.getParameter()){
            case "1":
                if (isParking()){
                    response.send("请输入车牌号：");
                    currentPage="parkService_park";
                }else {
                    response.send("车已停满，请晚点再来");
                    response.send("\n1.停车服务\n" + "2.停车场管理\n" + "请输入您要进入的页面：");
                }
                break;
            case "2":
                currentPage = "parkService_unpark";
                response.send("\n请输入小票编号：");
                break;
            default:
                response.send("\n非法指令，请查证后再输\n");

                //showMainPage();
                response.send("\n1.停车服务\n" + "2.停车场管理\n" + "请输入您要进入的页面：");

        }
        return currentPage;
    }
}
