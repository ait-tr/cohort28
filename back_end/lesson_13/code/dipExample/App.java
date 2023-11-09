package lesson13.dipExample;

public class App {
    public static void main(String[] args) {
        RepositoryList repositoryList = new RepositoryList();
        ServiceModule serviceModule = new ServiceModule(repositoryList);
        serviceModule.executorOperation("Data");
    }
}
