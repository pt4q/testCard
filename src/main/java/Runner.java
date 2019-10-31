import object_creation.ReadTestCardFromFile;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;

public class Runner {
    public static void main(String[] args) {
        String path = "D:\\KP\\Workspace\\Java\\testCard\\src\\test\\resources\\DED7850 Karta badań - Młotowiertarka_ref.csv";

        ReadTestCardFromFile testCardReader = new ReadTestCardFromFile();
        try {
            testCardReader.createTestCardFromFile(path);
        } catch (RecognizeParamTypeException e) {
            System.out.println(e.getMessage());
        }
    }
}
