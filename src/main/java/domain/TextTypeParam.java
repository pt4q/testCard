package domain;

import lombok.*;

@Data
public class TextTypeParam implements Param {
    private String nameInPolish = "";

    private Integer punctation = 0;
    private String type = "";

    private String valueString = "";
    private String measuredValue = "";
    private String declaredValue = "";

    public TextTypeParam(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }
}
