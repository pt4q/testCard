package object_creation.param;

enum ParamTypeEnum {
    HEADER("h"),
    BINARY("b"),
    TEXT("n"),
    DOUBLE("f"),
    INTEGER("i");

    private String regex;

    ParamTypeEnum(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return regex;
    }
}
