package org.mycode.fizzbuzzapp;

public class FizzBuzz {
    private int maxNumber;
    private volatile int currentNumber;
    private volatile String printStr;
    public FizzBuzz(int maxNumber){
        this.maxNumber = maxNumber;
        this.currentNumber = 1;
        this.printStr = "";
    }
    public synchronized void fizz(){
        while (currentNumber%3!=0 || currentNumber%5==0){
            try {
                if(currentNumber>=maxNumber) return;
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(currentNumber<maxNumber) {
            printStr+="fizz, ";
            currentNumber++;
        }
        else {
            printStr+="fizz";
        }
        notifyAll();
    }
    public synchronized void buzz(){
        while (currentNumber%5!=0 || currentNumber%3==0){
            try {
                if(currentNumber>=maxNumber) return;
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(currentNumber<maxNumber) {
            printStr+="buzz, ";
            currentNumber++;
        }
        else {
            printStr+="buzz";
        }
        notifyAll();
    }
    public synchronized void fizzBuzz(){
        while (currentNumber%3!=0 || currentNumber%5!=0){
            try {
                if(currentNumber>=maxNumber) return;
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(currentNumber<maxNumber) {
            printStr+="fizzbuzz, ";
            currentNumber++;
        }
        else {
            printStr+="fizzbuzz";
        }
        notifyAll();
    }
    public synchronized void number(){
        while (currentNumber%3==0 || currentNumber%5==0){
            try {
                if(currentNumber>=maxNumber) return;
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(currentNumber<maxNumber) {
            printStr+=currentNumber+", ";
            currentNumber++;
        }
        else {
            printStr+=currentNumber;
        }
        notifyAll();
    }
    public int getCurrentNumber() {
        return currentNumber;
    }
    public String getPrintStr() {
        return printStr;
    }
}
