package it.sevenbits.formatter.io.core_io;

import it.sevenbits.formatter.io.core_io.CloseException;

/**
 * Closable interface
 */
public interface IClosable extends AutoCloseable {
    @Override
    void close() throws CloseException;
}
