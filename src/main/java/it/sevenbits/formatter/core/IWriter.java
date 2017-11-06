package it.sevenbits.formatter.core;

/**
 * FileWriter interface.
 */
public interface IWriter extends ICloseble{

    /**
     * Write to file.
     * @param s String to write.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void write(String s) throws WriterException;

    /**
     * Close file.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void close() throws WriterException;
}
