package it.sevenbits.formatter.core;

import java.io.IOException;

/**
 * FileWriter interface.
 */
public interface IWriter {
    /**
     * Write to file.
     * @param s Char to write.
     * @throws IOException Failed or interrupted I/O operations.
     */
    void write(String s) throws IOException;

    /**
     * Close file.
     * @throws IOException Failed or interrupted I/O operations.
     */
    void close() throws IOException;
}
