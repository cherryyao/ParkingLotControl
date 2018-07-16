package com.thoughtworks.tdd;




import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FizzBuzzTest {

    @Test
    public void should_return_1_when_input_1(){
        //given
        int input=1;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("1"));
    }

    @Test
    public void should_return_2_when_input_2(){
        //given
        int input=2;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("2"));
    }
    @Test
    public void should_return_Fizz_when_input_3(){
        //given
        int input=3;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("Fizz"));
    }
    @Test
    public void should_return_Buzz_when_input_5(){
        //given
        int input=5;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("Buzz"));
    }
    @Test
    public void should_return_Whizz_when_input_7(){
        //given
        int input=7;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("Whizz"));
    }
    @Test
    public void should_return_FizzBuzz_when_input_15(){
        //given
        int input=15;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("FizzBuzz"));
    }
    @Test
    public void should_return_FizzWhizz_when_input_21(){
        //given
        int input=21;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("FizzWhizz"));
    }
    @Test
    public void should_return_BuzzWhizz_when_input_35(){
        //given
        int input=35;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("BuzzWhizz"));
    }

    @Test
    public void should_return_FizzBuzzWhizz_when_input_105(){
        //given
        int input=105;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("FizzBuzzWhizz"));
    }
    @Test
    public void should_return_Fizz_when_input_13(){
        //given
        int input=13;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("Fizz"));
    }
    @Test
    public void should_return_Fizz_when_input_35(){
        //given
        int input=35;

        //when
        FizzBuzz fizzbuzz = new FizzBuzz();
        String result = fizzbuzz.FizzBuzz(input);
        //then
        assertThat(result,is("Fizz"));
    }
}
