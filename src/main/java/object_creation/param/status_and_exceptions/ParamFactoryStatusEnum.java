package object_creation.param.status_and_exceptions;

public enum ParamFactoryStatusEnum {

    PARAM_BUILD_NOT_RECOGNIZED("Cant recognize param type"),
    PARAM_BUILD_ERR("Cant build param"),
    DOUBLE_PARAMETER_BUILDER_SUBTYPE_ERR("Cant build param with double value and subtype");

    private String message;

    ParamFactoryStatusEnum(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
