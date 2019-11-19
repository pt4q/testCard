package domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextTypeParam implements Param {
    private String nameInPolish;

    private Integer punctation;
    private String type;

    private String valueString;
    private String measuredValue;
    private String declaredValue;
}
