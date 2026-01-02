package Day_26_Practice_Problem;

import java.time.LocalDate;
import java.util.List;

public class HotelReservationMain {

    public static void main(String[] args) {

        HotelReservationSystem system =
                new HotelReservationSystem();

        // Add Hotels
        system.addHotel(new Hotel(
                "Lakewood", 3,
                110, 90,
                80, 80
        ));

        system.addHotel(new Hotel(
                "Bridgewood", 4,
                160, 60,
                110, 50
        ));

        system.addHotel(new Hotel(
                "Ridgewood", 5,
                220, 150,
                100, 40
        ));

        // ================= INPUT 1 =================
        List<LocalDate> dates1 = List.of(
                LocalDate.of(2020, 3, 16),
                LocalDate.of(2020, 3, 17),
                LocalDate.of(2020, 3, 18)
        );

        Hotel cheapest1 =
                system.findCheapestHotel(
                        CustomerType.REGULAR, dates1);

        int cost1 =
                system.calculateTotalCost(
                        cheapest1, CustomerType.REGULAR, dates1);

        System.out.println("OUTPUT 1: "
                + cheapest1.getName()
                + ", Total Rates: $" + cost1);

        // ================= INPUT 2 =================
        List<LocalDate> dates2 = List.of(
                LocalDate.of(2009, 3, 26),
                LocalDate.of(2009, 3, 27),
                LocalDate.of(2009, 3, 28)
        );

        Hotel cheapest2 =
                system.findCheapestHotel(
                        CustomerType.REWARDS, dates2);

        int cost2 =
                system.calculateTotalCost(
                        cheapest2, CustomerType.REWARDS, dates2);

        System.out.println("OUTPUT 2: "
                + cheapest2.getName()
                + ", Total Rates: $" + cost2);

        // ================= BEST RATED =================
        Hotel bestRated =
                system.findBestRatedHotel();

        System.out.println("Best Rated Hotel: "
                + bestRated.getName());
    }
}
