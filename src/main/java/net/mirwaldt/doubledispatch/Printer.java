package net.mirwaldt.doubledispatch;

import java.io.Closeable;
import java.io.IOException;

public interface Printer extends Closeable {
    void print(Text text) throws IOException;
    void print(Fraction fraction) throws IOException;
}
