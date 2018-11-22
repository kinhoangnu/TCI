public class DuplicateCourseException extends Exception{
    /**
     * own exception class. Used when no data items are present to do
     * calculations on.
     */

    public DuplicateCourseException() {
    }

    public DuplicateCourseException(String message) {
        super(message);
    }

    public DuplicateCourseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateCourseException(Throwable cause) {
        super(cause);
    }

    public DuplicateCourseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
