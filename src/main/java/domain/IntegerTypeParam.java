package domain;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class IntegerTypeParam implements Param <Integer> {
    private String nameInPolish = "";

    private Integer punctation = 0;
    private String type ="";

    private String valueString ="";
    private Integer measuredValue = 0;
    private Integer declaredValue = 0;

    public IntegerTypeParam(String nameInPolish) {
        this.nameInPolish = nameInPolish;
    }
}
