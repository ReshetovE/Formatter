package it.sevenbits.formatter.core;

/**
 * FileReader interface.
 */
public interface IReader extends ICloseble{

    /**
     * Checker char.
     * @return Are there next char?
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    boolean hasChars() throws ReaderException ;

    /**
     * ReadChar method.
     * @return New symbol.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    char readChar() throws ReaderException;

    /**
     * Close file.
     * @throws ReaderException Failed or interrupted I/O operations.
     */
    void close() throws ReaderException;
}