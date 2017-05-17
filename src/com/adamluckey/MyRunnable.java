package com.adamluckey;

import static com.adamluckey.ThreadColor.ANSI_RED;

/**
 * @author adam.luckey
 * @since 5/17/17
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from MyRunnables implementation of run");
    }
}
