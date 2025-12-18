package Java_8_Features.CollectorsApi;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Anbu", "IT", 60000),
                new Employee(2, "Ravi", "HR", 40000),
                new Employee(3, "Kumar", "IT", 55000),
                new Employee(4, "Sita", "Finance", 70000),
                new Employee(5, "Priya", "HR", 45000)
        );

        // 1️⃣ toList()
        System.out.println("1️⃣ toList()");
        List<Employee> list =
                employees.stream().collect(Collectors.toList());
        System.out.println(list);


        // 2️⃣ toSet()
        System.out.println("\n2️⃣ toSet()");
        Set<Employee> set =
                employees.stream().collect(Collectors.toSet());
        System.out.println(set);


        // 3️⃣ toMap()
        System.out.println("\n3️⃣ toMap()");
        Map<Integer, String> map =
                employees.stream()
                        .collect(Collectors.toMap(
                                Employee::getId,
                                Employee::getName
                        ));
        System.out.println(map);


        // 4️⃣ joining()
        System.out.println("\n4️⃣ joining()");
        String names =
                employees.stream()
                        .map(Employee::getName)
                        .collect(Collectors.joining(", "));
        System.out.println(names);


        // 5️⃣ counting()
        System.out.println("\n5️⃣ counting()");
        long count =
                employees.stream().collect(Collectors.counting());
        System.out.println("Employee Count = " + count);


        // 6️⃣ summarizingInt()
        System.out.println("\n6️⃣ summarizingInt()");
        IntSummaryStatistics stats =
                employees.stream()
                        .collect(Collectors.summarizingInt(Employee::getSalary));
        System.out.println(stats);


        // 7️⃣ groupingBy()
        System.out.println("\n7️⃣ groupingBy()");
        Map<String, List<Employee>> groupByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDept));
        System.out.println(groupByDept);


        // 8️⃣ partitioningBy()
        System.out.println("\n8️⃣ partitioningBy()");
        Map<Boolean, List<Employee>> partitionBySalary =
                employees.stream()
                        .collect(Collectors.partitioningBy(
                                e -> e.getSalary() > 50000
                        ));
        System.out.println(partitionBySalary);


        // 9️⃣ mapping()
        System.out.println("\n9️⃣ mapping()");
        Map<String, List<String>> deptNames =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDept,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        ));
        System.out.println(deptNames);


        // 🔟 reducing()
        System.out.println("\n🔟 reducing()");
        int totalSalary =
                employees.stream()
                        .collect(Collectors.reducing(
                                0,
                                Employee::getSalary,
                                Integer::sum
                        ));
        System.out.println("Total Salary = " + totalSalary);


        // 1️⃣1️⃣ collectingAndThen()
        System.out.println("\n1️⃣1️⃣ collectingAndThen()");
        List<Employee> unmodifiableList =
                employees.stream()
                        .collect(Collectors.collectingAndThen(
                                Collectors.toList(),
                                Collections::unmodifiableList
                        ));
        System.out.println(unmodifiableList);

        // unmodifiableList.add(new Employee(6,"Test","IT",10000)); // ❌ throws exception
    }
}