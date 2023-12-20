package daemonExample2;

public class DataBaseUtil {
    public static void main(String[] args) {
        DatabaseServer dbs = new DatabaseServer();
        Thread thread = new Thread(dbs);
        thread.setDaemon(true);
        thread.start();

        HttpConnector hc = new HttpConnector();
        Thread thread2 = new Thread(hc);
        thread2.setDaemon(true);
        thread2.start();

    }
}
