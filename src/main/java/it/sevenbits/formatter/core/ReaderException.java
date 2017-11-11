package it.sevenbits.formatter.core;

/**
 * Exception for Reader.
 */
public class ReaderException extends Exception {

    /**
     * ReaderException for Reader.
     * @param s Message Exception.
     * @param e Exception.
     */
    public ReaderException(final String s, final Throwable e) {
        super(s, e);
    }
}
