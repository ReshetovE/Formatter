package it.sevenbits.formatter.file_io;

import it.sevenbits.formatter.core.CloseException;
import it.sevenbits.formatter.core.IClosable;
import it.sevenbits.formatter.core.IReader;
import it.sevenbits.formatter.core.ReaderException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileReader implementation.
 */
public class FileReader implements IReader, IClosable {

    private BufferedReader reader = null;

    /**
     * Constructor FileReader.
     * @param path The path to the file.
     * @throws ReaderException If file not found.
     */
    public FileReader(final String path) throws ReaderException {
        try {
            reader = new BufferedReader(new java.io.FileReader(path));
        } catch (FileNotFoundException e) {
            throw new ReaderException("File not found", e);
        }
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
     * Close file method.
     * @throws CloseException Failed or interrupted I/O operations.
     */
    public void close() throws CloseException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new CloseException("Error", e);
        }
    }
}