package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class ParkingBoyTest {
    @Test
    public void should_park_successfully_given_parking_lot_is_not_full(){
//        ParkingLot parkingLot1 = new ParkingLot(1);
//        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
//        ParkingLotList.add(parkingLot1);
//        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);
//        try {
//            parkingBoy.parking(new Car());
//        }catch (ParkingLotException exception){
//            fail("should park successfully");
//        }
        ParkingLot mockParkingLot1 = mock(ParkingLot.class);
        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(mockParkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);
        Car theCar = new Car();
        parkingBoy.parking(theCar);
        verify(mockParkingLot1).park(theCar);
    }

    @Test
    public void should_get_specific_car_when_call_Pick_given_receipt_is_right(){
//        ParkingLot parkingLot1 = new ParkingLot(1);
//        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
//        ParkingLotList.add(parkingLot1);
//        ParkingLot parkingLot = new ParkingLot(1);
//        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);
//        Car theCar = new Car();
//        Receipt receipt = parkingBoy.parking(theCar);
//         assertThat(parkingBoy.pickCar(receipt),is(theCar));

        ParkingLot mockParkingLot1 = mock(ParkingLot.class);
        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(mockParkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);
        Car theCar = new Car();
        Receipt receipt = parkingBoy.parking(theCar);
        parkingBoy.pickCar(receipt);
        verify(mockParkingLot1).unPack(receipt);

    }

    @Test
    public void should_park_successfully_given_two_parking_lots(){
//        ParkingLot parkingLot1 = new ParkingLot(1);
//        ParkingLot parkingLot2 = new ParkingLot(1);
//        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
//        ParkingLotList.add(parkingLot1);
//        ParkingLotList.add(parkingLot2);
//        ParkingBoy parkingBoy =new ParkingBoy(ParkingLotList);
//        try {
//            parkingBoy.parking(new Car());
//        }catch (ParkingLotException exception){
//            fail("should park successfully");
//        }
        ParkingLot mockParkingLot1 = mock(ParkingLot.class);
        ParkingLot mockParkingLot2 = mock(ParkingLot.class);

        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(mockParkingLot1);
        ParkingLotList.add(mockParkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);

        Car theCar = new Car();
        Car anotherCar = new Car();

        parkingBoy.parking(theCar);
        when(mockParkingLot1.isFull()).thenReturn(true);
        parkingBoy.parking(anotherCar);

        verify(mockParkingLot1).park(theCar);
        verify(mockParkingLot2).park(anotherCar);
    }
    @Test
    public void should_get_specific_car_when_given_two_parking_lots(){
//        ParkingLot parkingLot1 = new ParkingLot(1);
//        ParkingLot parkingLot2 = new ParkingLot(1);
//        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
//        ParkingLotList.add(parkingLot1);
//        ParkingLotList.add(parkingLot2);
//        ParkingBoy parkingBoy =new ParkingBoy(ParkingLotList);
//        Car theCar = new Car();
//        Receipt receipt = parkingBoy.parking(theCar);
//        assertThat(parkingBoy.pickCar(receipt),is(theCar));
        ParkingLot mockParkingLot1 = mock(ParkingLot.class);
        ParkingLot mockParkingLot2 = mock(ParkingLot.class);

        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(mockParkingLot1);
        ParkingLotList.add(mockParkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);

        Car theCar = new Car();
        Receipt receipt1 =new Receipt();

        parkingBoy.parking(theCar);
        parkingBoy.pickCar(receipt1);
        when(mockParkingLot1.park(theCar)).thenReturn(receipt1);

        verify(mockParkingLot1).unPack(receipt1);
        //verify(mockParkingLot2).unPack(receipt2);
    }
    @Test
    public void should_park_by_order_when_given_two_parking_lots(){
//        ParkingLot parkingLot1 = new ParkingLot(1);
//        ParkingLot parkingLot2 = new ParkingLot(1);
//        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
//        ParkingLotList.add(parkingLot1);
//        ParkingLotList.add(parkingLot2);
//        ParkingBoy parkingBoy =new ParkingBoy(ParkingLotList);
//        Car theCar = new Car();
//        Receipt receipt1 = parkingBoy.parking(theCar);
//        assertThat(theCar,is(parkingLot1.unPack(receipt1)));
        ParkingLot mockParkingLot1 = mock(ParkingLot.class);
        ParkingLot mockParkingLot2 = mock(ParkingLot.class);

        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(mockParkingLot1);
        ParkingLotList.add(mockParkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);

        Car theCar = new Car();
        Car anotherCar =new Car();
        Receipt receipt1 =new Receipt();
        Receipt receipt2 = new Receipt();

        receipt1 = parkingBoy.parking(theCar);
        when(mockParkingLot1.unPack(receipt1)).thenReturn(theCar);
        when(mockParkingLot1.isFull()).thenReturn(true);
        receipt2 = parkingBoy.parking(anotherCar);
        when(mockParkingLot2.unPack(receipt2)).thenReturn(anotherCar);

        verify(mockParkingLot1).park(theCar);
        verify(mockParkingLot2).park(anotherCar);

    }

    @Test
    public void should_not_get_specific_car_when_call_unPark_given_receipt_is_wrong(){
        ParkingLot parkingLot1 = new ParkingLot(2);
        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
        ParkingLotList.add(parkingLot1);
        ParkingBoy parkingBoy =new ParkingBoy(ParkingLotList);
        Car theCar =new Car();
        Receipt receipt = parkingBoy.parking(theCar);
        Receipt anotherReceipt = parkingBoy.parking(new Car());
        assertThat(parkingBoy.pickCar(anotherReceipt),not(theCar));
//        ParkingLot mockParkingLot1 = mock(ParkingLot.class);
//        ParkingLot mockParkingLot2 = mock(ParkingLot.class);
//
//        List<ParkingLot> ParkingLotList  = new ArrayList<ParkingLot >();
//        ParkingLotList.add(mockParkingLot1);
//        ParkingLotList.add(mockParkingLot2);
//
//        ParkingBoy parkingBoy = new ParkingBoy(ParkingLotList);
//
//        Car theCar = new Car();
//        Receipt receipt1 =parkingBoy.parking(theCar);
//        Receipt receipt2 = parkingBoy.parking(new Car());
//
//        when(mockParkingLot1.unPack(receipt2)).thenReturn(new Car());
//        verify(mockParkingLot1).park(theCar);


    }


}
