package controller;

import view.Request;
import view.Response;

public class ManageController {
    private Response response =new Response();

    public void showMainPage() {
        response.send("\n1.停车服务\n" + "2.停车场管理\n" + "请输入您要进入的页面：");
    }

    public String MainPage(Request request) {
        String currentPage = "manageMain";
        switch (request.getParameter()){
            case "1":
                response.send("\n1.停车\n" + "2.取车\n" + "请输入您要进行的操作:");
                currentPage = "parkService";
                break;
            case "2":
                response.send(("\n1.查看停车场详情\n" + "2.添加停车场\n" + "3.删除停车场\n请输入您要进行的操作:\n"));
                currentPage = "LotsService";
                break;
            default:
                response.send("\n非法指令，请查证后再输");
                showMainPage();

        }
   return currentPage;
    }
}
