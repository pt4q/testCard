package domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class DoubleTypeParameter implements Param {
    private String nameInPolish;
    private String nameInEnglish;

    private Integer punctation;

    private String subtype;
    private Double value;
}
