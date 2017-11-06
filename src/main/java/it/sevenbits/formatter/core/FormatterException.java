package it.sevenbits.formatter.core;

/**
 * Exception for FormatterClass.
 */
public class FormatterException extends Exception{

    /**
     * ReaderException throw FormatterException.
     * @param s Message Exception.
     * @param e Exception.
     */
    public FormatterException(final String s, final ReaderException e) {
        super(s, e);
    }

    /**
     * WriterException throw FormatterException.
     * @param s Message Exception.
     * @param e Exception.
     */
    public FormatterException(final String s, final WriterException e) {
        super(s, e);
    }

    public FormatterException(final Exception e) {
        super(e);
    }
}
