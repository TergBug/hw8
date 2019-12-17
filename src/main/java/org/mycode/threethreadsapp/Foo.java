package org.mycode.threethreadsapp;

public class Foo {
    private int whichUp = 1;
    private volatile String strOnPrint = "";
    public synchronized void first(){
        while (whichUp!=1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        strOnPrint += "first";
        whichUp = 2;
        notify();
    }
    public synchronized void second(){
        while (whichUp!=2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        strOnPrint += "second";
        whichUp = 3;
        notify();
    }
    public synchronized void third(){
        while (whichUp!=3){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        strOnPrint += "third";
        whichUp = 1;
        notify();
    }
    public String getStrOnPrint() {
        return strOnPrint;
    }
}
