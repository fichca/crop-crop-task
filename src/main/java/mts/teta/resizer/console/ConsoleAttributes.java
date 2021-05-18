package mts.teta.resizer.console;

import mts.teta.resizer.imageprocessor.ConstantsException;
import picocli.CommandLine;

import java.io.File;

public class ConsoleAttributes {


    @CommandLine.Parameters(paramLabel = "FILE", defaultValue = ConstantsException.FILE_NOT_FOUND, description = "input file")
    protected File inputFile;

    @CommandLine.Parameters(paramLabel = "FILE", defaultValue = ConstantsException.FILE_NOT_FOUND, description = "output file")
    private File outputFile;

    @CommandLine.Option(names = "-he",  description = "height")
    protected int resizeHeight;

    @CommandLine.Option(names = "-w",  description = "width")
    protected int resizeWidth;

    @CommandLine.Option(names = "-q",  description = "quality")
    protected int quality;

    @CommandLine.Option(names = "-b",  description = "blur radius")
    protected int blurRadius;

    @CommandLine.Option(names = "-x",  description = "x")
    protected int x;

    @CommandLine.Option(names = "-y",  description = "y")
    protected int y;

    @CommandLine.Option(names = "-f",  description = "format")
    protected String format;

    @CommandLine.Option(names = "--",  description = "PEG/PNG compression level")
    protected String operation;


    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public int getResizeHeight() {
        return resizeHeight;
    }

    public void setResizeHeight(int resizeHeight) {
        this.resizeHeight = resizeHeight;
    }

    public int getResizeWidth() {
        return resizeWidth;
    }

    public void setResizeWidth(int resizeWidth) {
        this.resizeWidth = resizeWidth;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getBlurRadius() {
        return blurRadius;
    }

    public void setBlurRadius(int blurRadius) {
        this.blurRadius = blurRadius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }


    //    @CommandLine.Option(names={"-vwh", "--resize width height"}, description="resize the image")
//    private boolean resize;
//
//    @CommandLine.Option(names={"-qv", "--quality value"}, description="PEG/PNG compression level")
//    private boolean qualityValue;
//
//    @CommandLine.Option(names={"-cwh", "--crop width height x y"}, description="сut out one or more rectangular regions of the image")
//    private Integer[] integers;
//
//
//    @CommandLine.Option(names={"-b", "--blur {radius}"}, description="reduce image noise and reduce detail levels")
//    private boolean blur;
//
//    @CommandLine.Option(names={"-f", "--format \"outputFormat\""}, description="output formatted image characteristics")
//    private boolean format;
}
