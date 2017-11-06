package it.sevenbits.formatter.core;

/**
 * Formatter interface.
 */
public interface IFormatter {

    /**
     * Method formatter.
     * @param in Input interface FileReader.
     * @param out Input interface FileWriter.
     * @throws FormatterException ReaderException/WriterException.
     */
    void format(IReader in, IWriter out) throws FormatterException;
}
