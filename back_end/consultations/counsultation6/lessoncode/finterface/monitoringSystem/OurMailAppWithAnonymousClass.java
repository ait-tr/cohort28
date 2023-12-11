package finterface.monitoringSystem;

public class OurMailAppWithAnonymousClass {
    public static void main(String[] args) {

        MonitoringSystem generalIndicatorsMonitoringModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг общих показателей запущен.");
            }
        };

        MonitoringSystem errorMonitoringModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг отслеживания и контроля за ошибками запущен.");
            }
        };

        MonitoringSystem securityMonitoringModule = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг безопасности запущен.");
            }
        };

        generalIndicatorsMonitoringModule.startMonitoring();
        errorMonitoringModule.startMonitoring();
        securityMonitoringModule.startMonitoring();
    }
}
