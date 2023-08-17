package ait.messages.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageBoxC implements MessageBox {
    String message;
    Lock mutex = new ReentrantLock();
    Condition senderWaitingCondition = mutex.newCondition();
    Condition receiverWaitingCondition = mutex.newCondition();

    @Override
    public void post(String message) {
        mutex.lock();
        try {
            while (this.message != null) {
                try {
                    senderWaitingCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.message = message;
            receiverWaitingCondition.signal();
        } finally {
            mutex.unlock();
        }
    }

    @Override
    public String get() {
        mutex.lock();
        try {
            while (message == null) {
                try {
                    receiverWaitingCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String res = message;
            message = null;
            senderWaitingCondition.signal();
            return res;
        } finally {
            mutex.unlock();
        }
    }
}
