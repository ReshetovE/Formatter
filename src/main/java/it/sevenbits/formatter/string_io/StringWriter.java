package it.sevenbits.formatter.string_io;

import it.sevenbits.formatter.core.IWriter;

public class StringWriter implements IWriter {

    private String str;

    /**
     * Write to string;
     * @param s String to write.
     */
    public void write(final String s) {
        str += s;
    }

    /**
     * Appendix from IWriter.
     * No used.
     */
    public void close() {

    }

    /**
     * returns contained string
     * @return string
     */
    public String getString() {
        return str;
    }
}
