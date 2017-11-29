package it.sevenbits.formatter.io.core_io;

/**
 * FileWriter interface.
 */
public interface IWriter {

    /**
     * Write to file.
     * @param s String to write.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void write(String s) throws WriterException;
}
