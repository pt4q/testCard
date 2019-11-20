package domain;

import lombok.Data;

@Data
public class HeaderTypeParam implements Param<String> {

    private String nameInPolish = "";

    private String type = "";

    private String valueString = "";

    public HeaderTypeParam(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }

    @Override
    public Integer getPunctation() {
        return null;
    }

    @Override
    public String getMeasuredValue() {
        return null;
    }

    @Override
    public String getDeclaredValue() {
        return null;
    }
}
