package it.sevenbits.formatter.io.core_io;

/**
 * Exception for Closable.
 */
public class CloseException extends Exception {

    /**
     * Exception for Closable.
     * @param s Message Exception.
     * @param e Exception.
     */
    public CloseException(final String s, final Throwable e) {
        super(s, e);
    }
}
