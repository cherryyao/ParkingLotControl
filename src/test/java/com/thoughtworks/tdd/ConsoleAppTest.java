package com.thoughtworks.tdd;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ConsoleAppTest {


    @Test
    public void should_park_successfully_when_action_is_parking(){
        try {
            ConsoleApp consoleApp = new ConsoleApp();
            consoleApp.initParkingLot();
            consoleApp.park("C123456");

//            ConsoleApp consoleApp = mock(ConsoleApp.class);
//            ArrayList<ParkingLot> parkingLots = new ArrayList<>();
//            parkingLots.add(new ParkingLot(0));
//            ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
//            Receipt receipt = parkingBoy.parking(new Car("123"));
//            verify(consoleApp).park(receipt.getUUID().toString());
        }catch (ParkingLotFullException e){
            System.out.print("车已停满，请晚点再来");
        }
    }

    @Test
    public void should_park_unsuccessfully_when_action_is_parking(){
        try {

            ConsoleApp consoleApp = new ConsoleApp();
            ArrayList<ParkingLot> parkingLots = new ArrayList<>();
            parkingLots.add(new ParkingLot(0));
            ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
            consoleApp.park("C123456");
            fail("车已停满，请晚点再来");
        }catch (Exception e){
        }
    }

    @Test
    public void should_upark_successfully_when_action_is_unparking(){
        try{
            ConsoleApp consoleApp = new ConsoleApp();
            consoleApp.initParkingLot();
            UUID receiptUUID = consoleApp.park("C123456");
            consoleApp.unpark(receiptUUID.toString());

        }catch (UnparkExcepiton e){
            fail("非法小票，无法取出车，请查证后再输");
        }
    }

    @Test
    public void should_upark_unsuccessfully_when_action_is_unparking(){
        try{
            ConsoleApp consoleApp = new ConsoleApp();
            consoleApp.initParkingLot();
            //UUID receiptUUID = consoleApp.park("C123456");
            consoleApp.unpark(UUID.randomUUID().toString());
            fail("非法小票，无法取出车，请查证后再输");
        }catch (UnparkExcepiton e){}
    }


}
