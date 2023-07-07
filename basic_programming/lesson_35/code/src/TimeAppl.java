
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;

public class TimeAppl {
    // нет полей, не описали


    // методы
    public static void main(String[] args) { // исполняемый метод
        //LocalDate, LocalTime, LocalDateTime - хотим узнать у компьютера внутри нашей программы
        // Обратились к классу и создали перменную, кот. отвечает за объект из этого класса
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        LocalTime localTime = LocalTime.now(); // спросили текущее время
        System.out.println(localTime); // печатем значение переменной localTime
        // спрашиваеем дату и время
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // печать

        // обратились к классу LocalDate, переменная
        LocalDate gagarin = LocalDate.of(1961, 4, 12);
        System.out.println(gagarin); // вернул дату в международном формате, СОРТИРУЕМАЯ ДАТА

        int year = gagarin.getYear(); // получаю год как целое число
        System.out.println(gagarin.getYear());
        System.out.println(year);

        // это обращения к объекту и методу
        System.out.println("Day of month " + gagarin.getDayOfMonth());
        System.out.println("Day of week " + gagarin.getDayOfWeek());
        System.out.println("DayOfYear " + gagarin.getDayOfYear());

        System.out.println(gagarin.isBefore(currentDate)); // boolean
        System.out.println(gagarin.isAfter(currentDate)); // boolean

        System.out.println(gagarin.isBefore(gagarin)); // boolean
        System.out.println(gagarin.isAfter(gagarin)); // boolean

        System.out.println("+++++++Traveling in time +++++");
        // add days to current day
        LocalDate newDate = currentDate.plusDays(40);
        System.out.println(newDate);
        System.out.println(currentDate);
        // add days to current day
        newDate = currentDate.plusWeeks(8);
        System.out.println(newDate);
        // 2 month ago
        newDate = currentDate.minusMonths(2);
        System.out.println(newDate);
        // operations with CronoUnits -
        System.out.println(localDateTime.plus(9, ChronoUnit.HALF_DAYS));
        // CENTURIE - 100 лет, 1 век
        newDate = currentDate.plus(10, ChronoUnit.CENTURIES);
        System.out.println(newDate);
        // DECADES - 10 years
        newDate = currentDate.plus(10, ChronoUnit.DECADES);
        System.out.println(newDate);

        LocalDateTime newDateTime = localDateTime.plus(10, ChronoUnit.HOURS);
        System.out.println(newDateTime);

        // получение интервала времени
        long res = ChronoUnit.YEARS.between(gagarin, currentDate);
        System.out.println(res);
        res = ChronoUnit.MONTHS.between(gagarin, currentDate);
        System.out.println(res);
        res = ChronoUnit.DAYS.between(gagarin, currentDate);
        System.out.println(res);

        // чтобы узнать сколько сейчас человеку лет надо
        // текущая дата between дата рождения

        LocalDate lenin = LocalDate.of(1870, 4, 22);
        long age = ChronoUnit.YEARS.between(lenin, currentDate);
        System.out.println(age);
        System.out.println(lenin.compareTo(gagarin));

        // res - сколько лет прошло между датой gagarin (объект) и датой lenin (объект)
        res = ChronoUnit.YEARS.between(lenin, gagarin);

        System.out.println(res);
        System.out.println(gagarin.compareTo(gagarin));
        LocalDate[] dates = {gagarin, currentDate, lenin};
        System.out.println(Arrays.toString(dates));
        Arrays.sort(dates);
        System.out.println(Arrays.toString(dates));

        System.out.println("===== Date Formatter =====");
        DateTimeFormatter df = DateTimeFormatter.BASIC_ISO_DATE;
        System.out.println(gagarin.format(df));
        df = DateTimeFormatter.ISO_DATE;
        System.out.println(gagarin.format(df));
        df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(gagarin.format(df));
        df = DateTimeFormatter.ofPattern("dd/M/yyyy");
        System.out.println(gagarin.format(df));
        df = DateTimeFormatter.ofPattern("dd/MMM/yyyy");
        System.out.println(gagarin.format(df));
        df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
        System.out.println(gagarin.format(df));
        df = DateTimeFormatter.ofPattern("dd/MMMM/yyyy", Locale.forLanguageTag("uk"));
        System.out.println(gagarin.format(df));
        df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date1 = "06/07/2023";
        String date2 = "2023-02-02";

        LocalDate localDate1 = dateParse(date1);
        System.out.println(localDate1);
        LocalDate localDate2 = dateParse(date2);
        System.out.println(localDate2);
    }

    private static LocalDate dateParse(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]");
        return LocalDate.parse(date, df);
//        if (date.contains("-")) {
//            return LocalDate.parse(date);
//        } else {
//            return LocalDate.parse(date, df);
//        }


    }
}
