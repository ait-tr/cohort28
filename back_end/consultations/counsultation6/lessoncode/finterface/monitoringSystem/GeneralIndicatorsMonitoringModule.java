package finterface.monitoringSystem;

public class GeneralIndicatorsMonitoringModule implements MonitoringSystem{
    @Override
    public void startMonitoring() {
        System.out.println("Мониторинг общих показателей запущен.");
    }
}
