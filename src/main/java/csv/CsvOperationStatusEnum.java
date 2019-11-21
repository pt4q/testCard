package csv;

enum CsvOperationStatusEnum {

    FILE_NOT_FOUND("File not found"),
    FILE_READING_ERR("File reading error"),
    FILE_CANT_BE_SAVE("File can't be saved");

    private String message;

    CsvOperationStatusEnum(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
