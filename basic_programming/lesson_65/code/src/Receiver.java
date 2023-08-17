package ait.messages.task;

import ait.messages.model.MessageBox;

public class Receiver extends Thread {
    MessageBox messageBox;

    public Receiver(MessageBox messageBox) {
        this.messageBox = messageBox;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            String message = messageBox.get();
            System.out.println(message + " - receiver id " + getId());
        }
    }
}
