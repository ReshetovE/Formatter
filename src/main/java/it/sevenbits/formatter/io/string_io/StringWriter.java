package it.sevenbits.formatter.io.string_io;

import it.sevenbits.formatter.io.core_io.IWriter;

/**
 * StringWriter implementation.
 */
public class StringWriter implements IWriter {

    private StringBuilder builder = new StringBuilder();

    /**
     * Write to string.
     * @param s String to write.
     */
    public void write(final String s) {
        builder.append(s);
    }

    /**
     * Return contained string.
     * @return string
     */
    public String getString() {
        return builder.toString();
    }
}
