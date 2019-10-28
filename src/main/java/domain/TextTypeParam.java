package domain;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextTypeParam implements Param {
    private String nameInPolish;

    private Integer punctation;

    private String value;

}
