package OOPs_Banner_App;

import java.util.HashMap;
import java.util.Map;

public class OopsBannerApp {

    public static void main(String[] args) {
        uc1();
        uc2();
        uc3();
        uc4();
        uc5();
    }

    // ========================== UC1 ==========================
    public static void uc1() {
        String str = "OOPS";
        System.out.println(str);
    }

    // ========================== UC2 ==========================
    public static void uc2() {
        String[] O = {"  *****  ", " *     * ", "*       *", "*       *", "*       *", " *     * ", "  *****  "};
        String[] P = {"*******  ", "*      * ", "*      * ", "*******  ", "*        ", "*        ", "*        "};
        String[] S = {" ******* ", " *       ", " *       ", " ******* ", "       * ", "       * ", " ******* "};
        String[][] oops = {O, O, P, S};
        for (int row = 0; row < O.length; row++) {
            StringBuilder line = new StringBuilder();
            for (String[] letter : oops) {
                line.append(letter[row]).append(" ");
            }
            System.out.println(line.toString());
        }
    }

    // ========================== UC3 ==========================
    private static void uc3() {
        String[][] patterns = {
                getOPattern(),
                getOPattern(),
                getPPattern(),
                getSPattern()
        };

        printBanner(patterns);
    }

    private static String[] getOPattern() {
        return new String[]{
                "  *****  ",
                " *     * ",
                "*       *",
                "*       *",
                "*       *",
                " *     * ",
                "  *****  "
        };
    }

    private static String[] getPPattern() {
        return new String[]{
                "*******  ",
                "*      * ",
                "*      * ",
                "*******  ",
                "*        ",
                "*        ",
                "*        "
        };
    }

    private static String[] getSPattern() {
        return new String[]{
                " ******* ",
                " *       ",
                " *       ",
                " ******* ",
                "       * ",
                "       * ",
                " ******* "
        };
    }

    private static void printBanner(String[][] patterns) {
        for (int row = 0; row < 7; row++) {
            String line = "";
            for (String[] letter : patterns) {
                line = line + letter[row] + " ";
            }
            System.out.println(line);
        }
    }

    // ========================== UC4 ==========================
    private static void uc4() {

        BannerCharacter[] characters = {
                new BannerCharacter('O', getOPattern()),
                new BannerCharacter('O', getOPattern()),
                new BannerCharacter('P', getPPattern()),
                new BannerCharacter('S', getSPattern())
        };
        printBannerUC4(characters);
    }

    // Inner Class for Encapsulation
    static class BannerCharacter {
        private char character;
        private String[] pattern;

        public BannerCharacter(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public char getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    private static void printBannerUC4(BannerCharacter[] characters) {
        for (int row = 0; row < 7; row++) {
            StringBuilder line = new StringBuilder();
            for (BannerCharacter ch : characters) {
                line.append(ch.getPattern()[row]).append(" ");
            }
            System.out.println(line.toString());
        }
    }

    // ========================== UC5 ==========================
    private static void uc5() {
        Map<Character, String[]> patternMap = buildPatternMap();
        String word = "OOPS";
        printBannerUC5(word, patternMap);
    }

    private static Map<Character, String[]> buildPatternMap() {
        Map<Character, String[]> map = new java.util.HashMap<>();
        map.put('O', getOPattern());
        map.put('P', getPPattern());
        map.put('S', getSPattern());
        return map;
    }

    private static void printBannerUC5(String word, Map<Character, String[]> map) {
        for (int row = 0; row < 7; row++) {
            StringBuilder line = new StringBuilder();
            for (char ch : word.toCharArray()) {
                line.append(map.get(ch)[row]).append(" ");
            }
            System.out.println(line.toString());
        }
    }
}