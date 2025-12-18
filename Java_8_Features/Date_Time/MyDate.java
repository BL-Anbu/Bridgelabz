package Java_8_Features.Date_Time;

//@Deprecated(since="17", forRemoval=true)
public final class MyDate {

    final int day;
    final int month;
    final int year;

    private MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Factory method (like LocalDate.now())
    public static MyDate now() {
        java.time.LocalDate date = java.time.LocalDate.now();
        return new MyDate(
                date.getDayOfMonth(),
                date.getMonthValue(),
                date.getYear()
        );
    }

    // Factory method
    public static MyDate of(int day, int month, int year) {
        return new MyDate(day, month, year);
    }

    // plusDays (immutable)
    public MyDate plusDays(int days) {
        java.time.LocalDate date =
                java.time.LocalDate.of(year, month, day).plusDays(days);

        return new MyDate(
                date.getDayOfMonth(),
                date.getMonthValue(),
                date.getYear()
        );
    }

    @Override
    public String toString() {
        return day + "-" + month + "-" + year;
    }
}

