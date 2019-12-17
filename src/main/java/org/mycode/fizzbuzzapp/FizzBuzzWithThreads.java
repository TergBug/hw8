package org.mycode.fizzbuzzapp;

public class FizzBuzzWithThreads {
    public String runUpFizzBuzzThreads(int maxNumber){
        if(maxNumber<1) return null;
        FizzBuzz fizzBuzz = new FizzBuzz(maxNumber);
        Thread threadFizz = new Thread(() -> {
            do{
                fizzBuzz.fizz();
            }while (fizzBuzz.getCurrentNumber()<maxNumber);
        }, "Fizz");
        threadFizz.start();
        Thread threadBuzz = new Thread(() -> {
            do{
                fizzBuzz.buzz();
            }while (fizzBuzz.getCurrentNumber()<maxNumber);
        }, "Buzz");
        threadBuzz.start();
        Thread threadFizzBuzz = new Thread(() -> {
            do{
                fizzBuzz.fizzBuzz();
            }while (fizzBuzz.getCurrentNumber()<maxNumber);
        }, "FizzBuzz");
        threadFizzBuzz.start();
        Thread threadNumber = new Thread(() -> {
            do{
                fizzBuzz.number();
            }while (fizzBuzz.getCurrentNumber()<maxNumber);
        }, "Number");
        threadNumber.start();
        try {
            threadFizz.join();
            threadBuzz.join();
            threadFizzBuzz.join();
            threadNumber.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(fizzBuzz.getPrintStr());
        return fizzBuzz.getPrintStr();
    }
}
