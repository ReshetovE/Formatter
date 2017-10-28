package it.sevenbits.formatter.core;

import java.io.IOException;

/**
 * Formatter interface.
 */
public interface IFormatter {
    /**
     * Method formatter.
     * @param in Input interface Reader.
     * @param out Input interface Writer.
     * @throws IOException Failed or interrupted I/O operations.
     */
    void format(IReader in, IWriter out) throws IOException;

}
