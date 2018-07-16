import controller.ParkingboyController;
import view.Request;
import view.Response;

import java.util.UUID;

public class Router {

    private String currentPage;
    private ParkingboyController controller;
    private Response response = new Response();

    public Router(String currentPage, ParkingboyController controller) {
        this.currentPage = currentPage;
        this.controller = controller;
    }

    public  void handleRequest(Request request) {

        switch (currentPage){
            case "main":
                this.currentPage = controller.mainPage(request);
                break;
            case "park":
                controller.park(request.getParameter());
                this.currentPage = "main";
                break;
            case "unpark":
                controller.unPark(request.getParameter());
                this.currentPage = "main";
                break;
            default:
                response.send("非法指令，请查证后再输");
        }
    }

//    private void unparkPage(Request request) {
//       String carID = controller.unPark(request.getParameter());
//        response.send("车已取出，您的车牌号是: " +carID);
//    }
//
//    private void parkPage(Request request) {
//        UUID uuid = controller.park(request.getParameter());
//        response.send("停车成功，您的小票是："+uuid);
//    }

//    private void mainPage(Request request) {
//
//        switch (request.getParameter()){
//            case "1":
//                if (!controller.isFull()){
//                    this.currentPage = "park";
//                    response.send("请输入车牌号：");
//                }else {
//                    throw new ParkingLotException();
//                }
//            case "2":
//                this.currentPage = "unpark";
//                response.send("请输入小票：");
//             default:
//                 response.send("非法指令，请查证后再输");
//
//        }
//
//    }

}


