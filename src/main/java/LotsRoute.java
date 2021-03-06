import controller.LotsMangeController;
import controller.ManageController;
import controller.ParkingboyController;
import view.Request;
import view.Response;

public class LotsRoute {
    private String currentPage;
    private ManageController manageController;
    private LotsMangeController lotsController;
    private ParkingboyController parkingController;
    private Response response = new Response();

    public LotsRoute(String currentPage, ParkingboyController parkingController,LotsMangeController lotsController,ManageController manageController) {
        this.currentPage = currentPage;
        this.lotsController = lotsController;
        this.parkingController = parkingController;
        this.manageController = manageController;
    }

    public void handleRequest(Request request) {
        switch (currentPage){
            case "manageMain":
                 //manageController.showMainPage();
                 this.currentPage =manageController.MainPage(request);
                break;
            case "parkService":
                this.currentPage =parkingController.mainPage(request);
                break;
            case "parkService_park":
                parkingController.parkPage(request.getParameter());
                this.currentPage ="manageMain";
                break;
            case "parkService_unpark":
                parkingController.unparkPage(request);
                this.currentPage ="manageMain";
                break;
            case "LotsService":
                this.currentPage =lotsController.MainPage(request);
                break;
            case "LotsDetail":
                lotsController.printParkingLotDetails();
                this.currentPage ="manageMain";
                break;

        }
    }
}
