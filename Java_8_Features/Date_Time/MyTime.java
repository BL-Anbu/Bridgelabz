package Java_8_Features.Date_Time;

public final class MyTime {

    private final int hour;
    private final int minute;
    private final int second;

    private MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public static MyTime now() {
        java.time.LocalTime time = java.time.LocalTime.now();
        return new MyTime(
                time.getHour(),
                time.getMinute(),
                time.getSecond()
        );
    }

    public static MyTime of(int hour, int minute, int second) {
        return new MyTime(hour, minute, second);
    }

    public MyTime plusSeconds(int seconds) {
        java.time.LocalTime time =
                java.time.LocalTime.of(hour, minute, second).plusSeconds(seconds);

        return new MyTime(
                time.getHour(),
                time.getMinute(),
                time.getSecond()
        );
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}
