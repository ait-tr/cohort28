package ait.volatiles;

import ait.volatiles.task.InfinityLoop;

public class InfinityLoopAppl {
    public static void main(String[] args) throws InterruptedException {
        InfinityLoop task = new InfinityLoop();
        Thread thread1 = new Thread(task);
        thread1.start();
        Thread.sleep(3000);
        task.setFlag(false);
        System.out.println("In main thread flag = " + task.isFlag());
    }
}
