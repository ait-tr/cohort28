package finterface.monitoringSystem;

public class ErrorMonitoringModule implements MonitoringSystem{
    @Override
    public void startMonitoring() {
        System.out.println("Мониторинг отслеживания и контроля за ошибками запущен.");
    }
}
