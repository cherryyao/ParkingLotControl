package com.thoughtworks.tdd;

public class Car {
  private String id;
  public Car(){}

  public Car(String carID){
      id = carID;
  }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
