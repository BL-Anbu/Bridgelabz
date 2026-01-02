package Day_26_Practice_Problem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.function.ToLongFunction;

class HotelReservationSystem {

    private List<Hotel> hotels = new ArrayList<>();

    // UC: Add hotel
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    // UC: Calculate total cost
    public int calculateTotalCost(Hotel hotel,
                                  CustomerType type,
                                  List<LocalDate> dates) {

        return dates.stream()
                .mapToInt(date ->
                        hotel.getRate(type, date.getDayOfWeek()))
                .sum();
    }

    // UC: Find cheapest hotel (tie → highest rating)
    public Hotel findCheapestHotel(CustomerType type,
                                   List<LocalDate> dates) {

        Comparator<Hotel> cheapestComparator =
                Comparator.comparingInt((Hotel h) ->
                                calculateTotalCost(h, type, dates))
                        .thenComparing(
                                Comparator.comparingInt(Hotel::getRating).reversed()
                        );
        return hotels.stream()
                .min(cheapestComparator)
                .orElse(null);
    }

    // UC: Find best rated hotel
    public Hotel findBestRatedHotel() {

        return hotels.stream()
                .max(Comparator.comparingInt(Hotel::getRating))
                .orElse(null);
    }
}
