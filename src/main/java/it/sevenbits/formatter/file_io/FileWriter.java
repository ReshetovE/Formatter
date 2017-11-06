package it.sevenbits.formatter.file_io;

import it.sevenbits.formatter.core.IWriter;

import java.io.*;

/**
 * FileWriter implementation.
 */
public class FileWriter implements IWriter {
    private BufferedWriter writer = null;

    /**
     * Constructor FileWriter.
     * @param path The path to the file.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public FileWriter(final String path) throws IOException {
        try {
            writer = new BufferedWriter(new java.io.FileWriter(path));
        } catch (IOException e) {
            throw new IOException();
        }
    }


    /**
     * Write to file.
     * @param s Char to write.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public void write(final String s) throws IOException {
        try {
            writer.write(s);
        } catch (IOException e) {
            throw new IOException();
        }
    }

    /**
     * Close file.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public void close() throws IOException {
        try {
            writer.close();
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
