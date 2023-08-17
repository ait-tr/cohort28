package ait.messages.model;

public class MessageBoxA implements MessageBox {
    String message;
    @Override
    public synchronized void post(String message) {
        this.message = message;
        this.notify();
    }

    @Override
    public synchronized String get() {
        while(message == null){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String res = message;
        message = null;
        return res;
    }
}
