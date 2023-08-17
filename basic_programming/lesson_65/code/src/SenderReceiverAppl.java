package ait.messages;

import ait.messages.model.MessageBox;
import ait.messages.model.MessageBoxA;
import ait.messages.model.MessageBoxB;
import ait.messages.model.MessageBoxC;
import ait.messages.task.Receiver;
import ait.messages.task.Sender;

public class SenderReceiverAppl {
    private static final int N_MESSAGES = 20;
    private static final int N_RECEIVERS = 5;

    public static void main(String[] args) throws InterruptedException {
        MessageBox messageBox = new MessageBoxC();
        Sender sender = new Sender(messageBox, N_MESSAGES);
        for (int i = 0; i < N_RECEIVERS; i++) {
            new Receiver(messageBox).start();
        }
        Thread.sleep(100);
        sender.start();
        sender.join();
        Thread.sleep(100);
    }
}
