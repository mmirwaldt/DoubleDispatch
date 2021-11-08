package net.mirwaldt;

import net.mirwaldt.doubledispatch.Printable;
import net.mirwaldt.doubledispatch.Printer;

import java.io.IOException;

public record Fraction(int numerator, int denominator) implements Printable {
    @Override
    public void printOn(Printer printer) throws IOException {
        printer.print(this); // double dispatch
    }
}
