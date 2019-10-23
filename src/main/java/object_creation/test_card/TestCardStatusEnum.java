package object_creation.test_card;

public enum TestCardStatusEnum {

    CANT_FIND_BEGIN("Can't find begin of test card");

    private String message;

    TestCardStatusEnum(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
