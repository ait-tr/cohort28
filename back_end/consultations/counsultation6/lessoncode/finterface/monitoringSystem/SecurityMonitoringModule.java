package finterface.monitoringSystem;

public class SecurityMonitoringModule implements MonitoringSystem{
    @Override
    public void startMonitoring() {
        System.out.println("Мониторинг безопасности запущен.");
    }
}
