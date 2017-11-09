package it.sevenbits.formatter.core;

import java.io.IOException;

/**
 * Exception for WriterClass
 */
public class WriterException extends Exception {

    /**
     * WriterException for IOException.
     * @param s Message Exception.
     * @param e Exception.
     */
    public WriterException(final String s, final IOException e) {
        super(s, e);
    }
}
