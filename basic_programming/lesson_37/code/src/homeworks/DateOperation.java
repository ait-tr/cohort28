package ait.time.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DateOperation {

    public static int getAge(String birthDate) {
        LocalDate date = stringConvertToLocalDate(birthDate);
        return (int) ChronoUnit.YEARS.between(date, LocalDate.now());
    }

    public static String[] sortStringDates(String[] dates) {
        String[] res = Arrays.copyOf(dates, dates.length);
        Arrays.sort(res, (d1, d2) -> stringConvertToLocalDate(d1).compareTo(stringConvertToLocalDate(d2)));
        return res;
    }

    private static LocalDate stringConvertToLocalDate(String stringDate) {
        return LocalDate.parse(stringDate, DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]"));
    }

}
