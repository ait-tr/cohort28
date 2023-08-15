package ait.volatiles.task;

import java.util.concurrent.atomic.AtomicBoolean;

public class InfinityLoop implements Runnable {
    //volatile boolean flag = true;
    AtomicBoolean flag = new AtomicBoolean(true);

    public boolean isFlag() {
        return flag.get();
    }

    public void setFlag(boolean flag) {
//        this.flag = flag;
        this.flag.set(flag);
    }

    @Override
    public void run() {
        while (isFlag()) ;
        System.out.println("Infinity loop stopped");
    }
}
