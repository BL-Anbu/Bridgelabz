package Day_21_Practice_Problem;


public class MoodAnalysisException extends Exception {

    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
