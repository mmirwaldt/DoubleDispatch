package net.mirwaldt.doubledispatch;

import java.io.IOException;

public interface Printable {
    void printOn(Printer printer) throws IOException;
}
