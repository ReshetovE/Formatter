package it.sevenbits.formatter.string_io;

import it.sevenbits.formatter.core.IReader;
import it.sevenbits.formatter.core.ReaderException;

import java.io.*;

/**
 * StringReader implementation.
 */
public class StringReader implements IReader{

    private BufferedReader reader = null;

    /**
     * Constructor StringReader.
     * @param s Input string.
     */
    public StringReader(final String s) {
        reader = new BufferedReader(new java.io.StringReader(s));
    }

    /**
     * Checker char.
     * @return Checker last character.
     * @throws ReaderException  Failed or interrupted I/O operations.
     */
    public boolean hasChars() throws ReaderException {
        try {
            reader.mark(2);
            int buf = reader.read();
            reader.reset();
            return (-1 != buf);
        } catch (IOException e) {
            throw new ReaderException("Error IO", e);
        }
    }

    /**
     * ReadChar method.
     * @return Read character.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    public char readChar() throws ReaderException {
        try {
            reader.mark(1);
            return (char) reader.read();
        } catch (IOException e) {
            throw new ReaderException("Error IO", e);
        }
    }

    /**
     * Close BufferedReader.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    public void close() throws ReaderException {
        try {
            reader.close();
        } catch (IOException e){
            throw new ReaderException("Error IO", e);
        }
    }
}
