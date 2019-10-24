package object_creation.range_of_reserch;

public enum RangeOfResearchStatusEnum {
    NO_PUNCTATION("There're no punctation set");

    private String message;

    RangeOfResearchStatusEnum(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
