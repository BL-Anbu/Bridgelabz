package Java_8_Features.Date_Time;

public final class MyDateTime {

    private final MyDate date;
    private final MyTime time;

    private MyDateTime(MyDate date, MyTime time) {
        this.date = date;
        this.time = time;
    }

    public static MyDateTime now() {
        return new MyDateTime(MyDate.now(), MyTime.now());
    }

    public static MyDateTime of(MyDate date, MyTime time) {
        return new MyDateTime(date, time);
    }

    @Override
    public String toString() {
        return date + " " + time;
    }
}

