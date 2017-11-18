package it.sevenbits.formatter.core;

/**
 * FileReader interface.
 */
public interface IReader {

    /**
     * Checker char.
     * @return Are there next char?
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    boolean hasChars() throws ReaderException;

    /**
     * ReadChar method.
     * @return New symbol.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    char nextChar() throws ReaderException;
}