package ait.computer.model;

public class Smartphone extends Laptop {
    private long imei;

    public Smartphone(String cpu, int ram, int ssd, String brand, double hours, double weight, long imei) {
        super(cpu, ram, ssd, brand, hours, weight);
        this.imei = imei;
    }

    public long getImei() {
        return imei;
    }

    public String toString() {
        return super.toString() + ", IMEI: " + imei;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Smartphone)) {
            return false;
        }
        Smartphone other = (Smartphone) obj;
        return imei == other.imei;
    }
}
