package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.core.FormatterException;
import it.sevenbits.formatter.core.IFormatter;
import it.sevenbits.formatter.core.ILexer;
import it.sevenbits.formatter.core.IToken;
import it.sevenbits.formatter.core.IWriter;
import it.sevenbits.formatter.core.ReaderException;
import it.sevenbits.formatter.core.WriterException;

/**
 * Formatter implementation.
 */
public class Formatter implements IFormatter {

    /**
     * Method Formatter.
     * @param lexer Interface Lexer.
     * @param out Output interface FileReader.
     * @throws FormatterException ReaderException/WriterException.
     */
    public void format(final ILexer lexer, final IWriter out) throws FormatterException {
        try {
            final int indentSize = 4;
            int enclosure = 0;
            boolean checkEnter = false;

            while (lexer.hasMoreTokens()) {
                IToken token = lexer.readToken();
                String lexeme = token.getLexeme();
                switch (lexeme) {
                    case ";":
                        out.write(";");
                        out.write("\n");
                        checkEnter = true;
                        break;
                    case "{":
                        enclosure++;
                        out.write("{\n");
                        checkEnter = true;
                        break;
                    case "}":
                        for (int i = 0; i < (enclosure - 1) * indentSize; i++) {
                            out.write(" ");
                        }
                        out.write("}\n");
                        checkEnter = true;
                        enclosure--;
                        break;
                    default:
                        if (checkEnter) {
                            for (int i = 0; i < enclosure * indentSize; i++) {
                                out.write(" ");
                            }
                            checkEnter = false;
                        }
                        String s = "" + lexeme;
                        out.write(s);
                        break;
                }
            }
        } catch (ReaderException e) {
            throw new FormatterException("Method format failed", e);
        } catch (WriterException e) {
            throw new FormatterException("Method format failed", e);
        }
    }
}
