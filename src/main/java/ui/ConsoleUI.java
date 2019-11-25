package ui;

import config.TestCardAndParamMarks;
import object_creation.param.status_and_exceptions.RecognizeParamTypeException;
import picocli.CommandLine.*;

import java.util.List;

@Command(version = "v1.0.0", header = "Test Card Calculator")
public class ConsoleUI implements Runnable {

    @Parameters(arity = "1", paramLabel = "FILE", description = "input file location")
    private String fileLocation;

    @Option(arity = "1..", names = {"-n", "-file-name"}, description = "file name; e.g: \"-n fileName1 fileName2\"")
    private List<String> fileNames;

    @Option(names = {"-h", "-?", "--help"}, usageHelp = true, description = "display THIS message")
    private boolean helpRequested = false;

    @Option(names = {"-m", "--print-marks"}, description = "print default (type \"-m true\" if you want to use it) ")
    private boolean requestToPrintMarks;

    @Override
    public void run() {
        calcFile();
        printMarks();
    }

    private void calcFile() {
//        for (String singleFile : fileLocation)
        ConsoleRunner consoleRunner = new ConsoleRunner();
        try {
            consoleRunner.compute(fileLocation, fileNames);
        } catch (RecognizeParamTypeException e) {
            System.out.println(e.getMessage());
        }

//        System.out.println(fileLocation);
//        System.out.println(fileName.get(0));
//        System.out.println(fileName.get(1));
    }

    private void printMarks() {
        if (requestToPrintMarks)
            System.out.println(new TestCardAndParamMarks().toString());
    }
}
