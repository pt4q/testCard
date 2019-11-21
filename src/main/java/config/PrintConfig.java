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

    private LinkedHashMap<Integer, String> setDefaultValuesInColumnNamesWithNumbers(){
        columnNamesWithNumbers = new LinkedHashMap<>();

        columnNamesWithNumbers.put(0,"Nazwa");
        columnNamesWithNumbers.put(1,"Punktacja");
        columnNamesWithNumbers.put(2,"Wartość zmierzona oryginalna");
        columnNamesWithNumbers.put(3,"Wartośc deklarowana");
        columnNamesWithNumbers.put(4,"Wartość zmierzona przetworzona");
        columnNamesWithNumbers.put(5,"Różnica");
        columnNamesWithNumbers.put(6,"Procent odchyłki");
        columnNamesWithNumbers.put(7,"Liczba dostępnych parametrów");
        columnNamesWithNumbers.put(8,"Suma dostępnych pkt");
        columnNamesWithNumbers.put(9,"Suma przyznanych pkt");
        columnNamesWithNumbers.put(10,"Wynik");

        maxColumnNumber = columnNamesWithNumbers.size();
        return columnNamesWithNumbers;
    }
}
