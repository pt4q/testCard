package object_printing;

import config.TestCardConfig;
import domain.TestCard;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
class TestCardStringGenerator implements Generator<List<String>, TestCard> {

    @NonNull
    private TestCardConfig config;

    @Override
    public List<String> generate(TestCard input) {
        return null;
    }
}
