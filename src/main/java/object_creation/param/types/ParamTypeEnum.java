package object_creation.param.types;

public enum ParamTypeEnum {
    HEADER("h"),
    BINARY("b"),
    TEXT("n"),
    DOUBLE("f"),
    INTEGER("i"),
    PIC("");

    private String regex;

    ParamTypeEnum(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return regex;
    }
}
