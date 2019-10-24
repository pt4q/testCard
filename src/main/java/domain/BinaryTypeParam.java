package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BinaryTypeParam implements Param {
    private String nameInPolish;

    private Integer punctation;

    private boolean value;
}
