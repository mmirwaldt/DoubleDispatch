package net.mirwaldt.doubledispatch;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DoubleDispatchMain {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        Text text = new Text(List.of("First line", "Second line"));
        text.printOn(console);

        FileSystem fileSystem = new FileSystem();
        fileSystem.open(File.createTempFile("temp","file"));
        Fraction fraction = new Fraction(20, 15);
        fraction.printOn(fileSystem);
        fileSystem.close();
    }
}
