package ait.enums.model;

public enum Month {

    JAN(31), FEB(28), MAR(31), APR(30), MAY(31), JUN(30), JUL(31),
    AUG(31), SEP(30), OCT(31), NOV(30), DEC(31);
    private int days;

    private Month(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Month plusMonth(int quantity) {
        int index = ordinal();
        index = index + quantity;
        Month[] values = values();
        return values[index % values.length];
    }

    public static String getName(int num) {
        Month[] values = values();
        return values[(num - 1) % values.length].name();
    }

}
