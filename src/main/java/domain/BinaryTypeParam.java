package domain;

import lombok.*;

@Data
public class BinaryTypeParam implements Param {
    private String nameInPolish = "";

    private Integer punctation = 0;
    private String type = "";

    private String valueString = "";
    private Boolean measuredValue = false;
    private Boolean declaredValue = false;

    public BinaryTypeParam(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }
}
