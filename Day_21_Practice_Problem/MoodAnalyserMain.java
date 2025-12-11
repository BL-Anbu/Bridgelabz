package Day_21_Practice_Problem;

public class MoodAnalyserMain {

    public static void main(String[] args) {

        // Test 1: SAD Mood
        try {
            MoodAnalyser analyser1 = new MoodAnalyser("I am in Sad Mood");
            System.out.println("Test 1 Output: " + analyser1.analyseMood());
        } catch (MoodAnalysisException e) {
            System.out.println("Exception in Test 1: " + e.getMessage());
        }

        // Test 2: HAPPY Mood
        try {
            MoodAnalyser analyser2 = new MoodAnalyser("I am in Any Mood");
            System.out.println("Test 2 Output: " + analyser2.analyseMood());
        } catch (MoodAnalysisException e) {
            System.out.println("Exception in Test 2: " + e.getMessage());
        }

        // Test 3: Constructor Happy
        try {
            MoodAnalyser analyser3 = new MoodAnalyser("I am in Happy Mood");
            System.out.println("Test 3 Output: " + analyser3.analyseMood());
        } catch (MoodAnalysisException e) {
            System.out.println("Exception in Test 3: " + e.getMessage());
        }

        // Test 4: NULL Mood (Should throw MoodAnalysisException)
        try {
            MoodAnalyser analyser4 = new MoodAnalyser(null);
            System.out.println("Test 4 Output: " + analyser4.analyseMood());
        } catch (MoodAnalysisException e) {
            System.out.println("Test 4 Exception: " + e.type + " - " + e.getMessage());
        }

        // Test 5: EMPTY Mood (Should throw MoodAnalysisException)
        try {
            MoodAnalyser analyser5 = new MoodAnalyser("");
            System.out.println("Test 5 Output: " + analyser5.analyseMood());
        } catch (MoodAnalysisException e) {
            System.out.println("Test 5 Exception: " + e.type + " - " + e.getMessage());
        }

        // Test 6: Random mood
        try {
            MoodAnalyser analyser6 = new MoodAnalyser("Today is a great day!");
            System.out.println("Test 6 Output: " + analyser6.analyseMood());
        } catch (MoodAnalysisException e) {
            System.out.println("Exception in Test 6: " + e.getMessage());
        }
    }
}

