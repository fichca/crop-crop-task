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
//        String[] arguments = {"--resize",
//                "-w", "200",
//                "-he", "500",
//                "src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg",
//                "src/main/java/mts/teta/resizer/picture/123.jpg"};
//        String[] arguments = {"--crop",
//                "-w", "200",
//                "-he", "500",
//                "-x", "200", "-y", "300",
//                "src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg",
//                "src/main/java/mts/teta/resizer/picture/123.jpg"};
//        String[] arguments = { "--quality",
//                "-q", "1",
//                "-w", "20",
//                "-he", "500",
//                "src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg",
//                "src/main/java/mts/teta/resizer/picture/123.jpg"};
//        String[] arguments = { "--blur",
//                "-b", "10",
//                "src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg", "src/main/java/mts/teta/resizer/picture/123.jpg"};
//        String[] arguments = { "--format",
//                "-f", "JPEG",
//                "src/main/java/mts/teta/resizer/picture/J_R_R_Tolkien_The_Hobbit_1937.jpg", "src/main/java/mts/teta/resizer/picture/123"};
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
