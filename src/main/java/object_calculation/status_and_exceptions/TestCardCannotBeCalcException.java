package object_calculation.status_and_exceptions;

public class TestCardCannotBeCalcException extends Exception {
    public TestCardCannotBeCalcException(String message) {
        super(message);
    }
}
