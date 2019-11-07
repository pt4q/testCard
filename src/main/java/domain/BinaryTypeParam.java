package domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BinaryTypeParam implements Param {
    private String nameInPolish;

    private Integer punctation;
    private String type;

    private String valueString;
    private Boolean measuredValue;
    private Boolean declaredValue;
}
