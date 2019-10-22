package object_creation.param;

enum ParamTypeEnum {
    BINARY(""),
    DESIGNATION(""),
    FLOAT(""),
    INTEGER("");

    private String regex;

    ParamTypeEnum(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return regex;
    }
}
