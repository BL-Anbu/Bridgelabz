package Day_21_Practice_Problem;

import java.util.regex.Pattern;

public class MoodAnalyser {

    private String message;

    // REGEX patterns
    private static final Pattern SAD_PATTERN = Pattern.compile("(?i).*sad.*");
    private static final Pattern HAPPY_PATTERN = Pattern.compile("(?i).*happy.*");

    public MoodAnalyser() { }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {

        if (message == null)
            throw new MoodAnalysisException(ExceptionType.NULL_MOOD, "Mood cannot be NULL");

        if (message.trim().isEmpty())
            throw new MoodAnalysisException(ExceptionType.EMPTY_MOOD, "Mood cannot be EMPTY");

        if (SAD_PATTERN.matcher(message).matches())
            return "SAD";

        return "HAPPY";
    }
}

