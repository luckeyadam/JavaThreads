package com.adamluckey;

import static com.adamluckey.ThreadColor.ANSI_GREEN;
import static com.adamluckey.ThreadColor.ANSI_PURPLE;
import static com.adamluckey.ThreadColor.ANSI_RED;

/**
 * @author adam.luckey
 * @since 5/17/17
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        // Implement new threads by using the Thread class
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous thread");
            }
        }.start();

        // Create new threads using Runnable without anonymous class
        //Thread myRunnableThread = new Thread(new MyRunnable());

        // Create new threads using Runnable with anonymous class
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void
            run() {
                System.out.println(ANSI_RED+"Hello from the anonyomous class's implementation of run");
                try {
                    // example of joining another thread, which causes this thread to pause and
                    // wait for the other thread to terminate
                    anotherThread.join(); // a number can be added as a timeout to keep thread from running too long
                    System.out.println(ANSI_RED + "AnotherThread terminated, so I'm running again");
                } catch (InterruptedException e){
                    System.out.println(ANSI_RED+"I couldn't wait after all.  I was interrupted");
                }
            }
        });
        myRunnableThread.start();

        // example of interrupting a thread
        //anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from main thread.");
    }
}
