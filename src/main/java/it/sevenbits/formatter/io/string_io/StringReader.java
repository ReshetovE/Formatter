package it.sevenbits.formatter.io.string_io;

import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.core_io.ReaderException;

/**
 * StringReader implementation.
 */
public class StringReader implements IReader {

    private String str = null;
    private int index = 0;

    /**
     * Constructor StringReader.
     * @param s Input string.
     */
    public StringReader(final String s) {
        this.str = s;
    }

    /**
     * Checker char and increment index;
     * @return Checker last character.
     * @throws ReaderException  Failed or interrupted I/O operations.
     */
    public boolean hasChars() throws ReaderException {
        return index < str.length();
    }

    /**
     * ReadChar method.
     * @return Read character.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    public char nextChar() throws ReaderException {
        return str.charAt(index++);
    }
}
