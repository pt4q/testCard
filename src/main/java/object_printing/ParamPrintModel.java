package object_printing;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ParamPrintModel {

    @NonNull
    private Integer columnNumber;
    @NonNull
    private String stringValue;

}
