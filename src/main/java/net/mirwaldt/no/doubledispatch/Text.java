package net.mirwaldt.no.doubledispatch;

import java.util.List;

import static java.lang.String.join;

public record Text(List<String> lines) {
    public Text(List<String> lines) {
        this.lines = List.copyOf(lines);
    }

    @Override
    public String toString() {
        return join(System.lineSeparator(), lines());
    }
}
