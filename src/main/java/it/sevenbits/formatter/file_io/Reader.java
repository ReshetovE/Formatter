package it.sevenbits.formatter.file_io;

import it.sevenbits.formatter.core.IReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Reader implementation.
 */
public class Reader implements IReader {
    private FileInputStream inputStream;

    /**
     * Constructor Reader.
     * @param path The path to the file.
     * @throws FileNotFoundException If file not found.
     */
    public Reader(final String path) throws FileNotFoundException {
            inputStream = new FileInputStream(path);
    }

    /**
     * Checker char.
     * @return Checker last character.
     * @throws IOException  Failed or interrupted I/O operations.
     */
    public boolean hasChars() throws IOException {
            return inputStream.available() != 0;
    }

    /**
     * ReadChar method.
     * @return Read character.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public char readChar() throws IOException {
            return (char) inputStream.read();
    }

    /**
     * Close file method.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public void close() throws IOException {
        inputStream.close();
    }
}
