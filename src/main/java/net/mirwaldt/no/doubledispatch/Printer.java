package net.mirwaldt.no.doubledispatch;

import java.io.*;
import java.util.Objects;

public class Printer implements Closeable {
    private final PrinterDevice printerDevice;
    private DataOutputStream dataOutputStream;

    public Printer(PrinterDevice printerDevice) {
        this.printerDevice = printerDevice;
    }


    public void open(File file) throws FileNotFoundException {
        dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }

    void print(Text text) throws IOException {
        if(printerDevice.equals(PrinterDevice.CONSOLE)) {
            System.out.print(text);
        } else if(printerDevice.equals(PrinterDevice.FILE_SYSTEM)) {
            Objects.requireNonNull(dataOutputStream, "No file has yet been opened.");
            dataOutputStream.write(text.toString().getBytes());
            dataOutputStream.flush();
        }
    }

    void print(Fraction fraction) throws IOException {
        if(printerDevice.equals(PrinterDevice.CONSOLE)) {
            System.out.print(fraction.numerator());
            System.out.print(fraction.denominator());
        } else if(printerDevice.equals(PrinterDevice.FILE_SYSTEM)) {
            Objects.requireNonNull(dataOutputStream, "No file has yet been opened.");
            dataOutputStream.writeInt(fraction.numerator());
            dataOutputStream.writeInt(fraction.denominator());
            dataOutputStream.flush();
        }
    }

    @Override
    public void close() throws IOException {
        if(dataOutputStream != null) {
            dataOutputStream.close();
        }
    }
}
