package com.thoughtworks.tdd;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {


    private String id;
    private String lotsName;
    private int size;

    private Map<UUID,Car> carReceipt = new HashMap<>();


    public ParkingLot( String id, String lotsName,int size) {

        this.id = id;
        this.lotsName = lotsName;
        this.size = size;
    }

    public Receipt park(Car theCar) {
       if (isFull()) {
           throw new ParkingLotFullException();
       }else
       {
           Receipt receipt = new Receipt();
           UUID uuid = UUID.randomUUID();
           receipt.setUuid(uuid);
           carReceipt.put(receipt.getUUID(),theCar);
           return receipt;
       }

    }

    public Car unPack(Receipt receipt) {
        if (carReceipt.containsKey(receipt.getUUID())){
            Car car = carReceipt.get(receipt.getUUID());
            carReceipt.remove(receipt.getUUID());
            return car;
        }else {
            System.out.print("非法小票，无法取出车，请查证后再输");
            throw new UnparkExcepiton();
        }


    }

    public boolean isFull() {
        return carReceipt.size() == size;
    }

    public int getSize() {
        return size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLotsName() {
        return lotsName;
    }

    public void setLotsName(String lotsName) {
        this.lotsName = lotsName;
    }
    public Map<UUID, Car> getCarReceipt() {
        return carReceipt;
    }
}
