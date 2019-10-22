package domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class IntegerTypeParameter implements Param {
    private String nameInPolish;
    private String nameInEnglish;

    private Integer punctation;

    private Integer value;
}
