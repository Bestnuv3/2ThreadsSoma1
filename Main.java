package com.mycompany.threads;

public class Main{
    static int i = 0, x = 0;
    public static void main(String[] args) {
        new Thread(t1).start();
        new Thread(t2).start();
    }

    private static void countMe(String name){
        i++;
        System.out.println(name+ " Current Counter is: " + i);
    }

    private static Runnable t1 = new Runnable() {
        public void run() {
            try{
                while(i<15){
                    if(x==0){
                        countMe("T1");
                        x++;
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e){}
        }
    };

    private static Runnable t2 = new Runnable() {
        public void run() {
            try{
                Thread.sleep(500);
                while(i<15){
                    if(x==1){
                        countMe("T2");
                        x--;
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e){}
       }
    };
}
