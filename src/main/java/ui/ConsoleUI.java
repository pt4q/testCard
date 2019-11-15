package ui;

import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(version = "v1.0.0", header = "Test Card Calculator")
public class ConsoleUI implements Runnable {

    @Parameters(paramLabel = "FILE", description = "input file")
    String fileLocation;

    @Option(names = {"-c", "--print-to-console"}, description = "print results to console")
    boolean printToConsole;

    @Option(names = {"-f", "--print-to-file"}, description = "print results to file")
    boolean printToFile;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "display a help message")
    private boolean helpRequested = false;

    @Override
    public void run() {

    }
}
