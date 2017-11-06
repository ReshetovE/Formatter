package it.sevenbits.formatter.core;

import java.io.IOException;

/**
 * Formatter interface.
 */
public interface IFormatter {
    /**
     * Method formatter.
     * @param in Input interface FileReader.
     * @param out Input interface FileWriter.
     * @throws IOException Failed or interrupted I/O operations.
     */
    void format(IReader in, IWriter out) throws IOException;

}
