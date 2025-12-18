package Java_8_Features.StreamAPI;

import java.util.Arrays;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 10, 20, 10, 5);

        System.out.println("===== FILTER =====");
        MyStream.of(list)
                .filter(n -> n > 5)
                .forEach(System.out::println);


        System.out.println("\n===== MAP =====");
        MyStream.of(list)
                .map(n -> n * 10)
                .forEach(System.out::println);


        System.out.println("\n===== FLATMAP =====");
        MyStream.of(Arrays.asList(1, 2, 3))
                .flatMap(n -> Arrays.asList(n, n * 2))
                .forEach(System.out::println);


        System.out.println("\n===== DISTINCT =====");
        MyStream.of(list)
                .distinct()
                .forEach(System.out::println);


        System.out.println("\n===== SORTED NATURAL =====");
        MyStream.of(list)
                .sorted()
                .forEach(System.out::println);


        System.out.println("\n===== SORTED CUSTOM =====");
        MyStream.of(list)
                .sorted((a, b) -> b - a)
                .forEach(System.out::println);


        System.out.println("\n===== LIMIT =====");
        MyStream.of(list)
                .limit(3)
                .forEach(System.out::println);


        System.out.println("\n===== SKIP =====");
        MyStream.of(list)
                .skip(3)
                .forEach(System.out::println);


        System.out.println("\n===== PEEK =====");
        MyStream.of(list)
                .peek(n -> System.out.println("PEEK: " + n))
                .collect();


        System.out.println("\n===== MAP TO INT =====");
        MyStream.of(list)
                .mapToInt(n -> n * 2)
                .forEach(System.out::println);



        // ===== TERMINAL OPERATIONS =====

        System.out.println("\n===== COLLECT =====");
        List<Integer> collected = MyStream.of(list)
                .filter(n -> n > 5)
                .collect();
        System.out.println(collected);


        System.out.println("\n===== COUNT =====");
        long count = MyStream.of(list)
                .filter(n -> n > 5)
                .count();
        System.out.println("Count = " + count);


        System.out.println("\n===== FIND FIRST =====");
        Integer first = MyStream.of(list)
                .filter(n -> n > 5)
                .findFirst();
        System.out.println("First = " + first);


        System.out.println("\n===== ANY MATCH =====");
        boolean any = MyStream.of(list).anyMatch(n -> n == 20);
        System.out.println(any);


        System.out.println("\n===== ALL MATCH =====");
        boolean all = MyStream.of(list).allMatch(n -> n > 0);
        System.out.println(all);


        System.out.println("\n===== NONE MATCH =====");
        boolean none = MyStream.of(list).noneMatch(n -> n < 0);
        System.out.println(none);

        System.out.println("\n===== MIN =====");
        Integer min = MyStream.of(list).min(Integer::compareTo);
        System.out.println("Min = " + min);

        System.out.println("\n===== MAX =====");
        Integer max = MyStream.of(list).max(Integer::compareTo);
        System.out.println("Max = " + max);

        System.out.println("\n===== ALL TESTS COMPLETED =====");
    }
}

