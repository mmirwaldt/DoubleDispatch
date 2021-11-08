package net.mirwaldt.doubledispatch;

import net.mirwaldt.Fraction;
import net.mirwaldt.Text;

import java.io.*;
import java.util.Objects;

public class FileSystem implements Printer {
    private DataOutputStream dataOutputStream;

    public void open(File file) throws FileNotFoundException {
        dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }

    @Override
    public void print(Text text) throws IOException {
        Objects.requireNonNull(dataOutputStream, "No file has yet been opened.");
        dataOutputStream.write(text.toString().getBytes());
        dataOutputStream.flush();
    }

    @Override
    public void print(Fraction fraction) throws IOException {
        Objects.requireNonNull(dataOutputStream, "No file has yet been opened.");
        dataOutputStream.writeInt(fraction.numerator());
        dataOutputStream.writeInt(fraction.denominator());
        dataOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        if(dataOutputStream != null) {
            dataOutputStream.close();
        }
    }
}
