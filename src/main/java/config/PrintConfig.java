package config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;

@Getter
@RequiredArgsConstructor
public class PrintConfig {

    private int maxColumnNumber;

    @Setter
    private LinkedHashMap<Integer, String> columnNamesWithNumbers = setDefaultValuesInColumnNamesWithNumbers();

    private LinkedHashMap<Integer, String> setDefaultValuesInColumnNamesWithNumbers() {
        columnNamesWithNumbers = new LinkedHashMap<>();

        columnNamesWithNumbers.put(0, "Typ");
        columnNamesWithNumbers.put(1, "Nazwa");
        columnNamesWithNumbers.put(2, "Punktacja");
        columnNamesWithNumbers.put(3, "Wartość zmierzona oryginalna");
        columnNamesWithNumbers.put(4, "Wartośc deklarowana");
        columnNamesWithNumbers.put(5, "Wartość zmierzona przetworzona");
        columnNamesWithNumbers.put(6, "Różnica");
        columnNamesWithNumbers.put(7, "Procent odchyłki");
        columnNamesWithNumbers.put(8, "Liczba niedostępnych parametrów");
        columnNamesWithNumbers.put(9, "Suma dostępnych pkt");
        columnNamesWithNumbers.put(10, "Suma przyznanych pkt");
        columnNamesWithNumbers.put(11, "Wynik");

        maxColumnNumber = columnNamesWithNumbers.size();
        return columnNamesWithNumbers;
    }
}
