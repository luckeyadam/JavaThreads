package com.adamluckey;


import static com.adamluckey.ThreadColor.ANSI_BLUE;

/**
 * @author adam.luckey
 * @since 5/17/17
 */
public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println(ANSI_BLUE+"Hello from "+currentThread().getName());

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            //terminate this instance
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake");
    }
}
