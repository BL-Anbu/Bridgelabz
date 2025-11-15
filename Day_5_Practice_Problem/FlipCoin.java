package Day_5_Practice_Problem;

import java.util.Random;
import java.util.Scanner;

public class FlipCoin {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        String[] flips = {"head", "tail"};
        int head = 0;
        int tail = 0;
        System.out.print("Enter how many time need to flip the coin : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String flip = flips[random.nextInt(2)];
            if (flip == "head") {
                head++;
            } else {
                tail++;

            }
        }
        float headsPercent = (float) ((head * 100.0) / n);
        float tailsPercent = (float) ((tail * 100.0) / n);

        System.out.println("Heads count: " + head);
        System.out.println("Tails count: " + tail);
        System.out.println("Percentage of Heads: " + String.format("%.2f", headsPercent) + "%");
        System.out.println("Percentage of Tails: " + String.format("%.2f", tailsPercent) + "%");
    }
}
