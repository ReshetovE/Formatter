package it.sevenbits.formatter.core;

/**
 * Exception for FormatterClass.
 */
public class FormatterException extends Exception {

    /**
     * ReaderException for Formatter.
     * @param s Message Exception.
     * @param e Exception.
     */
    public FormatterException(final String s, final Throwable e) {
        super(s, e);
    }
}
