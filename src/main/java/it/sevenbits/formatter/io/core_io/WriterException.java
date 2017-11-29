package it.sevenbits.formatter.io.core_io;

/**
 * Exception for WriterClass
 */
public class WriterException extends Exception {

    /**
     * WriterException for Writer.
     * @param s Message Exception.
     * @param e Exception.
     */
    public WriterException(final String s, final Throwable e) {
        super(s, e);
    }
}
