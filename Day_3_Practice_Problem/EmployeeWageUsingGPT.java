package Day_3_Practice_Problem;

import java.util.*;

public class EmployeeWageUsingGPT {


    private static int FULL_DAY_HOURS = 8;
    private static int PART_TIME_HOURS = 4;
    private static final int DEFAULT_WORKING_DAYS_PER_MONTH = 20;
    private static final int DEFAULT_MAX_WORKING_HOURS = 100;
    private static final double DEFAULT_WAGE_PER_HOUR = 100.0;

    private final Random rand = new Random();
    private final List<String> log = new ArrayList<>();

    public static void main(String[] args) {
        EmployeeWageUsingGPT app = new EmployeeWageUsingGPT();
        app.runInteractive();
    }

    private void runInteractive() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
        System.out.println("UC1..UC6 supported. Use the menu to run any use-case.\n");

        // allow user to change defaults (especially PART_TIME_HOURS as requested)
        System.out.print("Default wage per hour [" + DEFAULT_WAGE_PER_HOUR + "]: ");
        String wageIn = sc.nextLine().trim();
        double wagePerHour = wageIn.isEmpty() ? DEFAULT_WAGE_PER_HOUR : parseDoubleOrDefault(wageIn, DEFAULT_WAGE_PER_HOUR);

        System.out.print("Full day hours (default " + FULL_DAY_HOURS + "): ");
        String fdh = sc.nextLine().trim();
        if (!fdh.isEmpty()) FULL_DAY_HOURS = parseIntOrDefault(fdh, FULL_DAY_HOURS);

        System.out.print("Part time hours (default " + PART_TIME_HOURS + ", set to 8 if you prefer): ");
        String pth = sc.nextLine().trim();
        if (!pth.isEmpty()) PART_TIME_HOURS = parseIntOrDefault(pth, PART_TIME_HOURS);

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose option (0 to exit): ");
            String choice = sc.nextLine().trim();
            int opt = parseIntOrDefault(choice, -1);
            switch (opt) {
                case 0 -> {
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                }
                case 1 -> {
                    boolean present = isEmployeePresent();
                    System.out.println("UC1 - Attendance: Employee is " + (present ? "PRESENT" : "ABSENT"));
                    log.add("UC1 - attendance: " + (present ? "PRESENT" : "ABSENT"));
                }
                case 2 -> {
                    System.out.print("Enter hours worked today (press Enter to use full-day if present, 0 if absent): ");
                    String hs = sc.nextLine().trim();
                    int hours = hs.isEmpty() ? FULL_DAY_HOURS : parseIntOrDefault(hs, FULL_DAY_HOURS);
                    double daily = calculateDailyWage(hours, wagePerHour);
                    System.out.printf("UC2 - Daily wage for %d hours = %.2f%n", hours, daily);
                    log.add(String.format("UC2 - daily: hours=%d, wage/hr=%.2f -> %.2f", hours, wagePerHour, daily));
                }
                case 3 -> {
                    System.out.printf("UC3 - Part-time configuration: PART_TIME_HOURS=%d, FULL_DAY_HOURS=%d%n", PART_TIME_HOURS, FULL_DAY_HOURS);
                    System.out.print("Simulate single-day (1) or monthly part-time calc (2)? Enter 1 or 2: ");
                    String m = sc.nextLine().trim();
                    if (m.equals("1")) {
                        double pWage = calculateDailyWage(PART_TIME_HOURS, wagePerHour);
                        System.out.printf("Part-time (hours=%d) daily wage = %.2f%n", PART_TIME_HOURS, pWage);
                        log.add(String.format("UC3 - part-time daily: hours=%d -> %.2f", PART_TIME_HOURS, pWage));
                    } else {
                        System.out.print("Enter number of part-time working days this month: ");
                        int days = parseIntOrDefault(sc.nextLine().trim(), DEFAULT_WORKING_DAYS_PER_MONTH);
                        double total = days * calculateDailyWage(PART_TIME_HOURS, wagePerHour);
                        System.out.printf("Monthly part-time wage (days=%d) = %.2f%n", days, total);
                        log.add(String.format("UC3 - part-time monthly: days=%d -> %.2f", days, total));
                    }
                }
                case 4 -> {
                    System.out.println("UC4 - Switch Case Example: classify employee type");
                    System.out.print("Enter 1=Absent, 2=Part-time, 3=Full-time: ");
                    int t = parseIntOrDefault(sc.nextLine().trim(), -1);
                    switch (t) {
                        case 1 -> System.out.println("Employee is ABSENT. Wage = 0");
                        case 2 -> System.out.println("Employee is PART-TIME. Hours = " + PART_TIME_HOURS);
                        case 3 -> System.out.println("Employee is FULL-TIME. Hours = " + FULL_DAY_HOURS);
                        default -> System.out.println("Invalid selection.");
                    }
                    log.add("UC4 - switch selection: " + t);
                }
                case 5 -> {
                    int wd = DEFAULT_WORKING_DAYS_PER_MONTH;
                    System.out.print("Enter working days for month (press Enter for default " + wd + "): ");
                    String wdin = sc.nextLine().trim();
                    if (!wdin.isEmpty()) wd = parseIntOrDefault(wdin, wd);
                    System.out.print("Use fixed full-time hours per day? (y/n, default y): ");
                    String fixed = sc.nextLine().trim();
                    double monthly;
                    if (fixed.isEmpty() || fixed.equalsIgnoreCase("y")) {
                        monthly = computeMonthlyWageFixedDays(wd, FULL_DAY_HOURS, wagePerHour);
                        System.out.printf("UC5 - Monthly wage (full-time %d hrs/day, %d days) = %.2f%n", FULL_DAY_HOURS, wd, monthly);
                        log.add(String.format("UC5 - monthly fixed: days=%d, hrs=%d -> %.2f", wd, FULL_DAY_HOURS, monthly));
                    } else {
                        // simulate random presence each day (present full-time or absent)
                        monthly = simulateMonthlyWage(wd, wagePerHour, 0.0); // partTimeProb 0 -> either absent or full-time
                        System.out.printf("UC5 - Monthly wage (simulated over %d days) = %.2f%n", wd, monthly);
                        log.add(String.format("UC5 - monthly simulated: days=%d -> %.2f", wd, monthly));
                    }
                }
                case 6 -> {
                    int maxDays = DEFAULT_WORKING_DAYS_PER_MONTH;
                    int maxHours = DEFAULT_MAX_WORKING_HOURS;
                    System.out.print("Max working days limit (default " + maxDays + "): ");
                    String md = sc.nextLine().trim();
                    if (!md.isEmpty()) maxDays = parseIntOrDefault(md, maxDays);

                    System.out.print("Max working hours limit (default " + maxHours + "): ");
                    String mh = sc.nextLine().trim();
                    if (!mh.isEmpty()) maxHours = parseIntOrDefault(mh, maxHours);

                    System.out.print("Use simulation? (y/n, default y): ");
                    String sim = sc.nextLine().trim();
                    boolean simulate = sim.isEmpty() || sim.equalsIgnoreCase("y");

                    if (simulate) {

                        System.out.print("When present, probability of part-time (0..1, default 0.5): ");
                        String pp = sc.nextLine().trim();
                        double partProb = pp.isEmpty() ? 0.5 : parseDoubleOrDefault(pp, 0.5);
                        WageUntilResult result = computeWagesUntilCondition(maxDays, maxHours, wagePerHour, partProb);
                        System.out.println("UC6 - Simulation complete:");
                        System.out.println("Total days counted: " + result.daysCount);
                        System.out.println("Total worked hours: " + result.totalHours);
                        System.out.printf("Total wages earned: %.2f%n", result.totalWage);
                        log.add(String.format("UC6 - simulated until days/%d or hours/%d -> days=%d, hours=%d, wage=%.2f",
                                maxDays, maxHours, result.daysCount, result.totalHours, result.totalWage));
                    } else {

                        WageUntilResult r = computeWagesUntilConditionDeterministic(maxDays, maxHours, wagePerHour);
                        System.out.println("UC6 - Deterministic run complete:");
                        System.out.println("Total days counted: " + r.daysCount);
                        System.out.println("Total worked hours: " + r.totalHours);
                        System.out.printf("Total wages earned: %.2f%n", r.totalWage);
                        log.add(String.format("UC6 - deterministic until days/%d or hours/%d -> days=%d, hours=%d, wage=%.2f",
                                maxDays, maxHours, r.daysCount, r.totalHours, r.totalWage));
                    }
                }
                default -> System.out.println("Unknown option. Choose from the menu.");
            }
            System.out.println();
        }

        System.out.println("=== Execution Log ===");
        log.forEach(System.out::println);
        sc.close();
    }

    private void printMenu() {
        System.out.println("===== MENU (UC4 switch-case) =====");
        System.out.println("1. UC1 - Check random attendance (present/absent)");
        System.out.println("2. UC2 - Calculate daily wage");
        System.out.println("3. UC3 - Part-time employee & wage (part-time hours configurable)");
        System.out.println("4. UC4 - Demonstration of switch-case classification");
        System.out.println("5. UC5 - Calculate wages for a month (assume 20 working days)");
        System.out.println("6. UC6 - Calculate wages until hours or days limit (assume 100 hrs / 20 days)");
        System.out.println("0. Exit");
    }

    /**
     * UC1: random attendance: 50% present/absent by default
     */
    private boolean isEmployeePresent() {
        return rand.nextBoolean();
    }

    /**
     * UC2: Calculate daily wage for given hours and wage/hour
     */
    private double calculateDailyWage(int hours, double wagePerHour) {
        if (hours <= 0) return 0.0;
        return hours * wagePerHour;
    }

    /**
     * UC3: Simulate monthly wage with partial/full presence using partTime probability
     */
    private double simulateMonthlyWage(int workingDays, double wagePerHour, double partTimeProb) {
        double total = 0.0;
        for (int d = 1; d <= workingDays; d++) {
            boolean present = rand.nextBoolean(); // random present/absent
            if (!present) {
                log.add("Day " + d + ": ABSENT");
                continue;
            }
            boolean partTime = rand.nextDouble() < partTimeProb;
            int hours = partTime ? PART_TIME_HOURS : FULL_DAY_HOURS;
            double daysWage = calculateDailyWage(hours, wagePerHour);
            total += daysWage;
            log.add(String.format("Day %d: PRESENT (%s) hours=%d wage=%.2f", d, (partTime ? "PART-TIME" : "FULL-TIME"), hours, daysWage));
        }
        return total;
    }

    /**
     * UC5: Fixed monthly calculation: full_time hours every working day
     */
    private double computeMonthlyWageFixedDays(int workingDays, int hoursPerDay, double wagePerHour) {
        return workingDays * hoursPerDay * wagePerHour;
    }

    /**
     * UC6: Simulate until hit maxDays or maxHours (stochastic simulation: absent/part/full)
     */
    private WageUntilResult computeWagesUntilCondition(int maxDays, int maxHours, double wagePerHour, double partTimeProb) {
        int daysCount = 0;
        int totalHours = 0;
        double totalWage = 0.0;

        while (daysCount < maxDays && totalHours < maxHours) {
            daysCount++;
            boolean present = rand.nextBoolean();
            if (!present) {
                log.add("Day " + daysCount + ": ABSENT");
                continue;
            }
            boolean partTime = rand.nextDouble() < partTimeProb;
            int hours = partTime ? PART_TIME_HOURS : FULL_DAY_HOURS;
            // but ensure not to exceed maxHours — if adding hours would exceed, truncate
            int hoursToAdd = Math.min(hours, maxHours - totalHours);
            double wage = hoursToAdd * wagePerHour;
            totalHours += hoursToAdd;
            totalWage += wage;
            log.add(String.format("Day %d: PRESENT (%s) hours=%d (added=%d) wage=%.2f", daysCount, (partTime ? "PART-TIME" : "FULL-TIME"), hours, hoursToAdd, wage));
        }
        return new WageUntilResult(daysCount, totalHours, totalWage);
    }

    /**
     * UC6 deterministic: assume every counted day is full-time until limits reached
     */
    private WageUntilResult computeWagesUntilConditionDeterministic(int maxDays, int maxHours, double wagePerHour) {
        int daysCount = 0;
        int totalHours = 0;
        double totalWage = 0.0;
        while (daysCount < maxDays && totalHours < maxHours) {
            daysCount++;
            int hoursToAdd = Math.min(FULL_DAY_HOURS, maxHours - totalHours);
            double wage = hoursToAdd * wagePerHour;
            totalHours += hoursToAdd;
            totalWage += wage;
            log.add(String.format("Deterministic Day %d: FULL-TIME hours=%d wage=%.2f", daysCount, hoursToAdd, wage));
            if (totalHours >= maxHours) break;
        }
        return new WageUntilResult(daysCount, totalHours, totalWage);
    }

    private static class WageUntilResult {
        int daysCount;
        int totalHours;
        double totalWage;

        WageUntilResult(int d, int h, double w) {
            daysCount = d;
            totalHours = h;
            totalWage = w;
        }
    }

    private static int parseIntOrDefault(String s, int def) {
        if (s == null || s.isEmpty()) return def;
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return def;
        }
    }

    private static double parseDoubleOrDefault(String s, double def) {
        if (s == null || s.isEmpty()) return def;
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return def;
        }
    }
}
