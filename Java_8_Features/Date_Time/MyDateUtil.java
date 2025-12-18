package Java_8_Features.Date_Time;

public class MyDateUtil {

    public static long daysBetween(MyDate d1, MyDate d2) {

        java.time.LocalDate date1 =
                java.time.LocalDate.of(d1.year, d1.month, d1.day);

        java.time.LocalDate date2 =
                java.time.LocalDate.of(d2.year, d2.month, d2.day);

        return java.time.temporal.ChronoUnit.DAYS.between(date1, date2);
    }
}

