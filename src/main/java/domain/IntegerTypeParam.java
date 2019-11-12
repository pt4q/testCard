package domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntegerTypeParam implements Param <Integer> {
    private String nameInPolish;

    private Integer punctation;
    private String type;

    private String valueString;
    private Integer measuredValue;
    private Integer declaredValue;

}
