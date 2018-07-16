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

}


