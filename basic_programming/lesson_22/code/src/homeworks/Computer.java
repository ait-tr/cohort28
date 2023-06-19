package ait.computer.model;

import java.util.Objects;

public class Computer {

    protected long barCode;
    protected String cpu;
    protected int ram;
    protected int ssd;
    protected String brand;

    public Computer(long barCode) {
        super();
        this.barCode = barCode;
    }

    public Computer(long barCode, String cpu, int ram, int ssd, String brand) {
        this.barCode = barCode;
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        this.brand = brand;
    }

    public long getBarCode() {
        return barCode;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Bar code: " + barCode + ", Brand: " + brand + ", CPU: " + cpu + ", RAM: " + ram + ", SSD: " + ssd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return barCode == computer.barCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barCode);
    }
}
