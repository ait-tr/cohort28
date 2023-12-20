package multi.multithreading;

public class MyFirstThread extends Thread{
    @Override
    public void run(){
        System.out.println("I'm Thread! Mu name is " + getName());
    }

}
