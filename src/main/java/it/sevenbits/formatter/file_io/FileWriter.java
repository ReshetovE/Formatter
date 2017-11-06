package it.sevenbits.formatter.file_io;

import it.sevenbits.formatter.core.IWriter;
import it.sevenbits.formatter.core.WriterException;

import java.io.*;

/**
 * FileWriter implementation.
 */
public class FileWriter implements IWriter {

    private BufferedWriter writer = null;

    /**
     * Constructor FileWriter.
     * @param path The path to the file.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    public FileWriter(final String path) throws WriterException {
        try {
            writer = new BufferedWriter(new java.io.FileWriter(path));
        } catch (IOException e) {
            throw new WriterException("Error IO", e);
        }
    }

    /**
     * Write to file.
     * @param s String to write.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    public void write(final String s) throws WriterException {
        try {
            writer.write(s);
        } catch (IOException e) {
            throw new WriterException("Error IO", e);
        }
    }

    /**
     * Close file.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    public void close() throws WriterException {
        try {
            writer.close();
        } catch (IOException e) {
            throw new WriterException("Error IO", e);
        }
    }
}
