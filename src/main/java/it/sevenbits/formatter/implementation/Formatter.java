package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.core.*;

/**
 * Formatter implementation.
 */
public class Formatter implements IFormatter {

    /**
     * Method Formatter.
     * @param in Input interface FileReader.
     * @throws FormatterException ReaderException/WriterException.
     */
    public void format(final IReader in, final IWriter out) throws FormatterException {
        try {
            while (in.hasChars()) {
                char c = in.readChar();
                if(c == ';') {
                    out.write(";");
                    out.write("\n");
                } else {
                    String s = "" + c;
                    out.write(s);
                }

            }
        } catch (ReaderException e) {
            throw new FormatterException("Method format failed", e);
        } catch (WriterException e) {
            throw new FormatterException("Method format failed", e);
        }
    }

    @Override
    public void close() throws Exception {

    }
}
