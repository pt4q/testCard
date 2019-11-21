package csv;

public enum CsvFileSeparatorEnum {

    TAB('\t'),
    COMMA(','),
    SEMICOLON(';');

    char separator;

    CsvFileSeparatorEnum(char separator) {
        this.separator = separator;
    }

    @Override
    public String toString() {
        return String.valueOf(separator);
    }

    public Character toCharacter(){
        return separator;
    }
}
