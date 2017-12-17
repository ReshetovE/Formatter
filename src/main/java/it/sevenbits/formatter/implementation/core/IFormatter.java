package it.sevenbits.formatter.implementation.core;

import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.lexer.core.ILexer;

/**
 * Formatter interface.
 */
public interface IFormatter {

    /**
     * Method formatter.
     * @param lexer Interface Lexer.
     * @param out Input interface FileWriter.
     * @throws FormatterException ReaderException/WriterException.
     */
    void format(ILexer lexer, IWriter out) throws FormatterException;
}
