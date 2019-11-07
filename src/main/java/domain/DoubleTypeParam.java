package domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoubleTypeParam implements Param {
    private String nameInPolish;

    private Integer punctation;
    private String type;

    private String valueString;
    private Double measuredValue;
    private Double declaredValue;

    public String toString() {
        return nameInPolish
                + " " + punctation.toString()
                + " " + measuredValue.toString() ;
    }

}
