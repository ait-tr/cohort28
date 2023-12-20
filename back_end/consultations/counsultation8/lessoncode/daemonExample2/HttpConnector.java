package daemonExample2;

public class HttpConnector implements Runnable{

    @Override
    public void run() {
        while (true){
            // делает запрос по http-протоколу по адресу ip
            // получает ответ
            // если ответ не пустой то положил почту в коллекцию
            // и ждет 5 минут
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
