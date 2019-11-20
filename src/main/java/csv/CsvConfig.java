package csv;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CsvConfig {

    @NonNull
    private String writerSeparator;
    @NonNull
    private String readerSeparator;
}
