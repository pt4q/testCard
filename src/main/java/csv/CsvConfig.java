package csv;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CsvConfig {

    @NonNull
    private CsvFileSeparatorEnum writerSeparator;
    @NonNull
    private CsvFileSeparatorEnum readerSeparator;
}
