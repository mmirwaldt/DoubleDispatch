package net.mirwaldt;

import net.mirwaldt.doubledispatch.Printable;
import net.mirwaldt.doubledispatch.Printer;

import java.io.IOException;
import java.util.List;

import static java.lang.String.join;

public record Text(List<String> lines) implements Printable {
    public Text(List<String> lines) {
        this.lines = List.copyOf(lines);
    }

    @Override
    public void printOn(Printer printer) throws IOException {
        printer.print(this); // double dispatch
    }

    @Override
    public String toString() {
        return join(System.lineSeparator(), lines());
    }
}
