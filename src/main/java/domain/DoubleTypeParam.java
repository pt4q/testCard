package domain;


import lombok.*;

@Data
public class DoubleTypeParam implements Param {
    private String nameInPolish = "";

    private Integer punctation = 0;
    private String type = "";

    private String valueString = "";
    private Double measuredValue = 0.0;
    private Double declaredValue = 0.0;

    public String toString() {
        return nameInPolish
                + " " + punctation.toString()
                + " " + measuredValue.toString() ;
    }

    public DoubleTypeParam(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }
}
