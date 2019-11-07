package domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntegerTypeParam implements Param {
    private String nameInPolish;

    private Integer punctation;
    private String type;

    private String readValueString;
    private Integer measuredValue;
    private Integer declaredValue;
}
