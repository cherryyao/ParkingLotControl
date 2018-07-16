package com.thoughtworks.tdd;

public class FizzBuzz {


    public String FizzBuzz(int number) {
        StringBuffer result = new StringBuffer();
        if(number % 3 == 0){
            result.append("Fizz");
        }
        if(number % 5 == 0){
            result.append("Buzz");
        }
        if(number % 7 == 0){
            result.append("Whizz");
        }
        if (String.valueOf(number).contains("3")){
            return "Fizz";
        }
        return "".equals(result.toString())? String.valueOf(number) : result.toString();
    }
}
