package it.sevenbits.formatter.core;

/**
 * Exception for WriterClass
 */
public class WriterException extends Exception {

    /**
     * WriterException for Writer.
     * @param s Message Exception.
     * @param e Exception.
     */
    public WriterException(final String s, final Exception e) {
        super(s, e);
    }
}
