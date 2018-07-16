package controller;

import view.Request;
import view.Response;

public class LotsMangeController {
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
                response.send(("\n请输入你要添加的停车场信息（格式为：名称，车位）：\n"));
                currentPage = "InsertLotDetail";
                break;
            case "3":
                response.send(("请输入需要删除的被管理停车场ID:\n"));
                currentPage = "DelLotID";
                break;
            default:
                response.send("\n非法指令，请查证后再输\n");
                showMainPage();

        }
        return currentPage;
    }
}
