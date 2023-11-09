package lesson13.dipExample;

public class ServiceModule {

    Repository repository;

    public ServiceModule(Repository repository) {
        this.repository = repository;
    }

    public void executorOperation(String data){
        repository.prepareData(data);
    }
}
