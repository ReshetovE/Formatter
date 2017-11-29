package it.sevenbits.formatter.io.core_io;

/**
 * Closable interface
 */
public interface IClosable extends AutoCloseable {
    @Override
    void close() throws CloseException;
}
