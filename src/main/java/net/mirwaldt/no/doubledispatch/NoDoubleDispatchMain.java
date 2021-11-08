package net.mirwaldt.no.doubledispatch;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class NoDoubleDispatchMain {
    public static void main(String[] args) throws IOException {
        Printer consolePrinter = new Printer(PrinterDevice.CONSOLE);
        Text text = new Text(List.of("First line", "Second line"));
        consolePrinter.print(text);

        Fraction fraction = new Fraction(1, 3);
        Printer filePrinter = new Printer(PrinterDevice.FILE_SYSTEM);
        filePrinter.open(File.createTempFile("temp","file"));
        filePrinter.print(fraction);
        filePrinter.close();
    }
}
