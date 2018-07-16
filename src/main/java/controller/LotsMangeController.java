package controller;

import com.thoughtworks.tdd.ParkingBoy;
import com.thoughtworks.tdd.ParkingLot;
import view.Request;
import view.Response;

import java.util.ArrayList;
import java.util.List;

public class LotsMangeController {
    List<ParkingLot> ParkingLotList = new ArrayList<>();
    private ParkingBoy parkingBoy =new ParkingBoy(ParkingLotList);
    private Response response =new Response();

    public void showMainPage() {
        response.send("1.查看停车场详情\n" + "2.添加停车场\n" + "3.删除停车场\n");
    }

    public String MainPage(Request request) {
        String currentPage = "LotsService";
        switch (request.getParameter()){
            case "1":
                //response.send(" ");
                currentPage = "LotsDetail";
                break;
            case "2":
                response.send(("\n请输入你要添加的停车场信息（格式为：名称，车位）："));
                currentPage = "InsertLotDetail";
                break;
            case "3":
                response.send(("请输入需要删除的被管理停车场ID:"));
                currentPage = "DelLotID";
                break;
            default:
                response.send("\n非法指令，请查证后再输");
                showMainPage();

        }
        return currentPage;
    }

    public void printParkingLotDetails(){
        StringBuffer result = new StringBuffer();
        result.append("|停车场ID|名称|车位|已停车辆|剩余车位|\n");
        List<ParkingLot> parkingLotList = parkingBoy.getParkingLotList();

        for (int i=0;i<parkingLotList.size();i++){
            String id = parkingLotList.get(i).getId();
            String name = parkingLotList.get(i).getLotsName();
            int size = parkingLotList.get(i).getSize();
            int parkedSize =parkingLotList.get(i).getCarReceipt().size();
            int unparkSize = size- parkedSize;
            result.append("|"+ id +"|"+ name +"|"+ size +"|"+ parkedSize +"|"+ unparkSize +"|\n");
        }
        response.send(result.toString());
        response.send("1. 停车服务\n" + "2. 停车场管理 \n" + "请输入您要进入的页面：");
    }

    public void parkingManageAddPage(Request request){
        String[] arr = request.getParameter().split(",");
        if (arr.length !=2 ){
            response.send("输入格式有误！正确格式为（名称，车位）");
        }else{
            ParkingLot parkingLot =new ParkingLot("001",arr[0],Integer.valueOf(arr[1]).intValue());
            parkingBoy.getParkingLotList().add(parkingLot);
            response.send("停车场添加成功！");
        }
    }

}
