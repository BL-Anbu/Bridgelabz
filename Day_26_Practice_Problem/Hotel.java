package Day_26_Practice_Problem;

import java.time.DayOfWeek;

public class Hotel {

    private String name;
    private int rating;

    private int weekdayRegularRate;
    private int weekendRegularRate;

    private int weekdayRewardsRate;
    private int weekendRewardsRate;

    public Hotel(String name, int rating,
                 int weekdayRegularRate, int weekendRegularRate,
                 int weekdayRewardsRate, int weekendRewardsRate) {

        this.name = name;
        this.rating = rating;
        this.weekdayRegularRate = weekdayRegularRate;
        this.weekendRegularRate = weekendRegularRate;
        this.weekdayRewardsRate = weekdayRewardsRate;
        this.weekendRewardsRate = weekendRewardsRate;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getRate(CustomerType type, DayOfWeek day) {

        boolean isWeekend =
                day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;

        if (type == CustomerType.REGULAR) {
            return isWeekend ? weekendRegularRate : weekdayRegularRate;
        } else {
            return isWeekend ? weekendRewardsRate : weekdayRewardsRate;
        }
    }
}

