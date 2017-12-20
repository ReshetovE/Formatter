package it.sevenbits.formatter.implementation.core;

/**
 * Exception for FormatterConfig class.
 */
public class FormatterConfigException extends Exception {

    /**
     * InstantiationException, IllegalAccessException, ClassNotFoundException for FormatterConfig.
     * @param s Message Exception.
     * @param e Exception.
     */
    public FormatterConfigException(final String s, final Throwable e) {
        super(s, e);
    }
}
