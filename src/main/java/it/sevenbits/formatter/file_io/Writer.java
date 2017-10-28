package it.sevenbits.formatter.file_io;

import it.sevenbits.formatter.core.IWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Writer implementation.
 */
public class Writer implements IWriter {
    private FileOutputStream outputStream;

    /**
     * Constructor Writer.
     * @param path The path to the file.
     * @throws FileNotFoundException If file not found.
     */
    public Writer(final String path) throws FileNotFoundException {
            outputStream = new FileOutputStream(path);
    }


    /**
     * Write to file.
     * @param s Char to write.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public void write(final String s) throws IOException {
        outputStream.write(s.getBytes());
    }

    /**
     * Close file.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public void close() throws IOException {

    }
}
