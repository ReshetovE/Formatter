package it.sevenbits.formatter.file_io;

import it.sevenbits.formatter.core.IWriter;

import java.io.*;

/**
 * Writer implementation.
 */
public class Writer implements IWriter {
    private BufferedWriter writer = null;

    /**
     * Constructor Writer.
     * @param path The path to the file.
     * @throws IOException Failed or interrupted I/O operations.
     */
    public Writer(final String path) throws IOException {
        try {
            writer = new BufferedWriter(new FileWriter(path));
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
