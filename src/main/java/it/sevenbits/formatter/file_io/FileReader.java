package it.sevenbits.formatter.file_io;

import it.sevenbits.formatter.core.IReader;

import java.io.*;

/**
 * FileReader implementation.
 */
public class FileReader implements IReader {

    private BufferedReader reader = null;

    /**
     * Constructor FileReader.
     * @param path The path to the file.
     * @throws FileNotFoundException If file not found.
     */
    public FileReader(final String path) throws FileNotFoundException {
        try {
            reader = new BufferedReader(new java.io.FileReader(path));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }

    /**
     * Checker char.
     * @return Checker last character.
     * @throws IOException  Failed or interrupted I/O operations.
     */
    public boolean hasChars() throws IOException {
        try {
            reader.mark(2);
            int buf = reader.read();
            reader.reset();
            return (-1 != buf);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    /**
     * ReadChar method.
     * @return Read character.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public char readChar() throws IOException {
        try {
            reader.mark(1);
            return (char) reader.read();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    /**
     * Close file method.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public void close() throws IOException {
        try {
            reader.close();
        } catch (IOException e){
            throw new IOException();
        }
    }
}
