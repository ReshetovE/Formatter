package it.sevenbits.formatter.implementation.core;

import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.core_io.IWriter;

/**
 * Formatter interface.
 */
public interface IFormatter {

    /**
     * Method formatter.
     * @param in Input interface Reader.
     * @param out Output interface Writer.
     * @throws FormatterException ReaderException/WriterException.
     */
    void format(IReader in, IWriter out) throws FormatterException;
}
