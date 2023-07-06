package ait.enums.model;

public class MonthAppl {
    public static void main(String[] args) {
        Month month = Month.DEC;
        System.out.println(month);
        System.out.println(month.plusMonth(3));
        System.out.println(month.plusMonth(13));
        System.out.println(Month.getName(7));
        System.out.println(Month.JUL.getDays());
    }

}
