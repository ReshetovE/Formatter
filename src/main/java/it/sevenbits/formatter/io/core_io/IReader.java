package it.sevenbits.formatter.io.core_io;

/**
 * FileReader interface.
 */
public interface IReader {

    /**
     * Checker char.
     * @return Are there next char?
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    boolean hasNextChars() throws ReaderException;

    /**
     * ReadChar method.
     * @return New symbol.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    char readChar() throws ReaderException;
}