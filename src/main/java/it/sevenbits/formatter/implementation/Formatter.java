package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.core.IFormatter;
import it.sevenbits.formatter.core.IReader;
import it.sevenbits.formatter.core.IWriter;
import it.sevenbits.formatter.file_io.Writer;

import java.io.IOException;

/**
 * Formatter implementation.
 */
public class Formatter implements IFormatter {

    /**
     * Method Formatter.
     * @param in Input interface Reader.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public void format(final IReader in, final IWriter out) throws IOException {
        while (in.hasChars()) {
            char c = in.readChar();
            if(c == ';') {
                out.write(";");
                out.write("\n");
            } else {
                String s = "" + c;
                out.write(s);
            }

        }
    }
}
