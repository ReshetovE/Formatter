package it.sevenbits.formatter.core;

import java.io.*;

/**
 * Exception for Reader.
 */
public class ReaderException extends Exception{

    /**
     * ReaderException file not found.
     * @param s Message Exception.
     * @param e Exception.
     */
    public ReaderException(final String s, final FileNotFoundException e) {
        super(s, e);
    }

    /**
     * ReaderException for IOException.
     * @param s Message Exception.
     * @param e Exception.
     */
    public ReaderException(final String s, final IOException e) {
        super(s, e);
    }
}
