package it.sevenbits.formatter.io.string_io;

import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.core_io.ReaderException;

/**
 * StringReader implementation.
 */
public class StringReader implements IReader {

    private String content = null;
    private int index = 0;

    /**
     * Constructor StringReader.
     * @param content Input string.
     */
    public StringReader(final String content) {
        this.content = content;
    }

    /**
     * Checker char and increment index;
     * @return Checker last character.
     * @throws ReaderException  Failed or interrupted I/O operations.
     */
    public boolean hasNextChars() throws ReaderException {
        return index < content.length();
    }

    /**
     * ReadChar method.
     * @return Read character.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    public char readChar() throws ReaderException {
        return content.charAt(index++);
    }
}
