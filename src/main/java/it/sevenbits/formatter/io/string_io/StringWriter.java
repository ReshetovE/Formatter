package it.sevenbits.formatter.io.string_io;

import it.sevenbits.formatter.io.core_io.IWriter;

/**
 * StringWriter implementation.
 */
public class StringWriter implements IWriter {

    private StringBuilder content = new StringBuilder();

    /**
     * Write to string.
     * @param s String to write.
     */
    public void write(final String s) {
        content.append(s);
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
