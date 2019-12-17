package org.mycode.threethreadsapp;

public class ThreeThread {
    public String runUpThreeThreads(int[] orderOfThreads){
        if(orderOfThreads==null || orderOfThreads.length!=3 || !dupSearchAndValidNums(orderOfThreads)) return null;
        Foo classFoo = new Foo();
        Thread[] threadsABC = new Thread[3];
        for (int i = 0; i < orderOfThreads.length; i++) {
            switch (orderOfThreads[i]){
                case 1:
                    threadsABC[i] = new Thread(classFoo::first);
                    break;
                case 2:
                    threadsABC[i] = new Thread(classFoo::second);
                    break;
                case 3:
                    threadsABC[i] = new Thread(classFoo::third);
                    break;
            }
            threadsABC[i].start();
        }
        try {
            for (Thread thread : threadsABC) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(classFoo.getStrOnPrint());
        return classFoo.getStrOnPrint();
    }
    private boolean dupSearchAndValidNums(int[] mas){
        for (int i = 0; i < mas.length; i++) {
            if(mas[i]<1 || mas[i]>3) return false;
            for (int j = i+1; j < mas.length; j++) {
                if(mas[i]==mas[j]) return false;
            }
        }
        return true;
    }
}
