package exception;

public class SniffException extends Exception {
    protected static String errorMessage;

    public SniffException(String e) {
        errorMessage = e;
    }
    public static String getErrorMessage() {
        return errorMessage;
    }
    public static void showError() {
        System.out.println(errorMessage);
    }
}
