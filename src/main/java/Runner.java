import object_creation.ReadTestCardFromFile;

public class Runner {
    public static void main(String[] args) {
        String path = "D:\\KP\\Workspace\\Java\\testCard\\src\\test\\resources\\DED7850 Karta badań - Młotowiertarka_ref.csv";

        ReadTestCardFromFile testCardReader = new ReadTestCardFromFile();
        testCardReader.createTestCardFromFile(path);
    }
}
