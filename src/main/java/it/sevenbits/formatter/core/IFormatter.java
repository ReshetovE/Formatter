package it.sevenbits.formatter.core;

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
