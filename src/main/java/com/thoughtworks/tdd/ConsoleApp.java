package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SplittableRandom;
import java.util.UUID;

public class ConsoleApp {

    private ParkingBoy parkingBoy;

    public static void main(String[] args){
        ConsoleApp consoleApp = new ConsoleApp();
        consoleApp.initParkingLot();
        consoleApp.start();
    }


    public void start(){
        while (true) {
            output("1.停车\n" + "2.取车\n" + "请输入您要进行的操作:\n");
            String action = readInput();
            if (action.equals("1")) {
                output("请输入车牌号:");
                String inputCarID = readInput();
                try {
                    UUID uuid = park(inputCarID);
                    output("停车成功，您的小票是：\n" + uuid+"\n");
                } catch (ParkingLotFullException e) {
                    output("车已停满，请晚点再来");
                }
            } else if (action.equals("2")) {
                output("请输入小票编号：");
                String inputRecipit = readInput();
                try {

                    String carID = unpark(inputRecipit);
                    output("车已取出，您的车牌号是: " + carID+"\n");
                } catch (UnparkExcepiton e) {
                    output("非法小票，无法取出车，请查证后再输\n");
                }

            } else {
                output("非法指令，请查证后再输");
            }


        }
    }

    public String unpark(String  inputRecipit) {
        try{
            Receipt receipt = new Receipt(UUID.fromString(inputRecipit));
            Car car = parkingBoy.pickCar(receipt);
            return car.getId();
        }catch (Exception e){
            throw new UnparkExcepiton();
        }


    }

    public void initParkingLot(){
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(new ParkingLot(3));
        parkingBoy = new ParkingBoy(parkingLots);
    }

    public UUID park(String inputs) {
        if(parkingBoy.isParking()){
            Car car = new Car(inputs);
            Receipt receipt = parkingBoy.parking(car);
            return receipt.getUUID();
        }else{
            throw new ParkingLotFullException();
        }
    }

    private String readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public String output(String message){
        System.out.print(message);
        return message;
    }
}
