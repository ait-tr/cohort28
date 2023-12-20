package daemonExample2;

public class DatabaseServer implements Runnable{

    @Override
    public void run() {
        while (true){
            // сохраняем изменения в базу данных
            //ждем 10 минут
            try {
                Thread.sleep(600000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
