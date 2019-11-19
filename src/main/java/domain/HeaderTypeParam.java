package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeaderTypeParam implements Param<String> {

    private String nameInPolish;

    private String type;

    private String valueString;

    @Override
    public Integer getPunctation() {
        return null;
    }

    @Override
    public String getMeasuredValue() {
        return null;
    }

    @Override
    public String getDeclaredValue() {
        return null;
    }
}
