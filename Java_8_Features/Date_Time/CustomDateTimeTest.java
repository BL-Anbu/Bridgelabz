package Java_8_Features.Date_Time;

public class CustomDateTimeTest {

    public static void main(String[] args) {

        System.out.println("---- Custom Date ----");
        MyDate today = MyDate.now();
        System.out.println("Today: " + today);

        MyDate future = today.plusDays(10);
        System.out.println("After 10 days: " + future);


        System.out.println("\n---- Custom Time ----");
        MyTime now = MyTime.now();
        System.out.println("Now: " + now);

        MyTime later = now.plusSeconds(120);
        System.out.println("After 120 seconds: " + later);


        System.out.println("\n---- Custom DateTime ----");
        MyDateTime dateTime = MyDateTime.now();
        System.out.println("DateTime: " + dateTime);


        System.out.println("\n---- Date Difference ----");
        long diff = MyDateUtil.daysBetween(today, future);
        System.out.println("Days difference: " + diff);
    }
}


