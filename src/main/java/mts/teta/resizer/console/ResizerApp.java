package mts.teta.resizer.console;

import mts.teta.resizer.service.ImageProcessor;
import mts.teta.resizer.service.OperationServiceImpl;
import mts.teta.resizer.validator.Validator;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "resizer", mixinStandardHelpOptions = true, version = "resizer 0.0.1", description = "...")
public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {
    private Validator validator = new Validator();

    public static void main(String... args) {
//        String[] arguments = {"--resize",
//                "-w", "-200",
//                "-he", "500",
//                "src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg",
//                "src/main/java/mts/teta/resizer/picture/123.jpg"};
                String[] arguments = {"--crop",
                "-w", "200",
                "-he", "500",
                "-x", "200", "-y", "300",
                "src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg",
                "src/main/java/mts/teta/resizer/picture/123.jpg"};
//        String[] arguments = { "--quality",
//                "-q", "1",
//                "src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg",
//                "src/main/java/mts/teta/resizer/picture/123.jpg"};
//        String[] arguments = { "--blur",
//                "-b", "10",
//                "src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg", "src/main/java/mts/teta/resizer/picture/123.jpg"};
//        String[] arguments = { "--format",
//                "-f", "PNG",
//                "src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg", "src/main/java/mts/teta/resizer/picture/123.jpg"};
        int exitCode = runConsole(arguments);
        System.exit(exitCode);
    }

    protected static int runConsole(String[] args) {
        return new CommandLine(new ResizerApp()).execute(args);
    }

    @Override
    public Integer call() throws Exception {
        long l = System.currentTimeMillis();
        if (validator.validParameters(this)) {
            ImageProcessor imageProcessor = new ImageProcessor(new OperationServiceImpl());
            imageProcessor.processImage(this);
        }
        System.out.println(System.currentTimeMillis() - l);
        return 0;
    }
}
