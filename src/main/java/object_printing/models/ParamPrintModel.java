package object_printing.models;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ParamPrintModel {

    @NonNull
    private Integer columnNumber;
    @NonNull
    private String stringValue;

}
