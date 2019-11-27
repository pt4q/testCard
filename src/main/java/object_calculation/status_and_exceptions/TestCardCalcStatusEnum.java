package object_calculation.status_and_exceptions;

public enum TestCardCalcStatusEnum {
    NOT_ENOUGH_PUNCTATION_TO_CALC("In the test card there is not enough punctations to calc test card components");

    private String message;

    TestCardCalcStatusEnum(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
