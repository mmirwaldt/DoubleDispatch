package net.mirwaldt.doubledispatch;

import java.io.IOException;

public class Console implements Printer {
    @Override
    public void print(Text text) throws IOException {
        System.out.print(text.toString());
    }

    @Override
    public void print(Fraction fraction) throws IOException {
        System.out.print(fraction.numerator());
        System.out.print('/');
        System.out.print(fraction.denominator());
    }

    @Override
    public void close() throws IOException {

    }
}
