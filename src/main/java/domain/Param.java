package domain;

import java.util.List;

public interface Param <T> {

    String getNameInPolish();
    Integer getPunctation();
    String getType();
    String getValueString();
    T getMeasuredValue();
    T getDeclaredValue();

}
