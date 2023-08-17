package ait.messages.model;

public interface MessageBox {
    void post(String message);

    String get();
}
