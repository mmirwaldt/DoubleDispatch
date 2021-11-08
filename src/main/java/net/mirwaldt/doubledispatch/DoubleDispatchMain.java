package net.mirwaldt.doubledispatch;

import net.mirwaldt.Fraction;
import net.mirwaldt.Text;

import java.io.File;
import java.io.IOException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

public class DoubleDispatchMain {
    public static void main(String[] args) throws IOException {
        Console console = new Console();
        Text text = new Text(List.of("First line", "Second line"));
        text.printOn(console);

        Fraction fraction = new Fraction(20, 15);
        FileSystem fileSystem = new FileSystem();
        fileSystem.open(File.createTempFile("temp","file"));
        fraction.printOn(fileSystem);
        fileSystem.close();

        LocalDate wrongMeetingOneWeekLater = LocalDate.of(2021, Month.JANUARY, 30);
        System.out.println(wrongMeetingOneWeekLater.plus(1, ChronoUnit.MONTHS));
    }
}
