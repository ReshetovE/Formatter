package it.sevenbits.formatter.core;

import java.io.IOException;

/**
 * FileReader interface.
 */
public interface IReader {
    /**
     * Checker char.
     * @return Are there next char?
     * @throws IOException Failed or interrupted I/O operations.
     */
    boolean hasChars() throws IOException ;

    /**
     * ReadChar method.
     * @return New symbol.
     * @throws IOException Failed or interrupted I/O operations.
     */

    char readChar() throws IOException;

    /**
     * Close file.
     * @throws IOException Failed or interrupted I/O operations.
     */
    void close() throws IOException;
}