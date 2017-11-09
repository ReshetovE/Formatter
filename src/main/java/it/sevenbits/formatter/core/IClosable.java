package it.sevenbits.formatter.core;

/**
 * Closable interface
 */
public interface IClosable extends AutoCloseable {
    @Override
    void close() throws CloseException;
}
