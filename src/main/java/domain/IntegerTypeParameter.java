package domain;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntegerTypeParameter implements Param {
    private String nameInPolish;

    private Integer punctation;

    private Integer value;
}
