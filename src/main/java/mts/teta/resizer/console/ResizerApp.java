package mts.teta.resizer.console;

import mts.teta.resizer.service.ImageProcessor;
import mts.teta.resizer.service.OperationServiceImpl;
import mts.teta.resizer.validator.Validator;
import picocli.CommandLine;

import java.util.concurrent.Callable;


// Описание в README
@CommandLine.Command(name = "resizer", mixinStandardHelpOptions = true, version = "resizer 0.0.1", description = "...")
public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {
    private Validator validator = new Validator();

    public static void main(String... args) {
        int exitCode = runConsole(args);
        System.exit(exitCode);
    }

    protected static int runConsole(String[] args) {
        return new CommandLine(new ResizerApp()).execute(args);
    }

    @Override
    public Integer call() throws Exception {
        if (validator.validParameters(this)) {
            ImageProcessor imageProcessor = new ImageProcessor(new OperationServiceImpl());
            imageProcessor.processImage(this);
        }
        return 0;
    }
}
