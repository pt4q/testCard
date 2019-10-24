package domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoubleTypeParameter implements Param {
    private String nameInPolish;

    private Integer punctation;

    private String subtype;
    private Double value;
}
