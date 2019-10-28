package object_creation.test_card;

public enum TestCardStatusEnum {

    CANT_FIND_BEGIN("Can't find begin of test card"),
    CANT_GET_HEADER("Can't get test card begin");

    private String message;

    TestCardStatusEnum(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
