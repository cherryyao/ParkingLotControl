package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot > ParkingLotList= new ArrayList<ParkingLot >();

    public ParkingBoy(List<ParkingLot> parkingLotList) {

        ParkingLotList = parkingLotList;
    }

    public Receipt parking(Car car) {
        Receipt receipt = new Receipt();
        for (int i = 0; i < ParkingLotList.size(); i++) {
            if (!ParkingLotList.get(i).isFull()) {
            receipt = ParkingLotList.get(i).park(car);
                break;
            }

        }
        return receipt;
    }

    public Car pickCar(Receipt receipt) {
       Car car =  new Car();
       try{
           for (int i =0;i<ParkingLotList.size();i++) {
               car = ParkingLotList.get(i).unPack(receipt);
               break;
           }

       }catch (UnparkExcepiton e ){

       }
        return car;
    }

    public boolean isParking() {
        return ParkingLotList.stream().allMatch(x->!x.isFull());
    }
}


