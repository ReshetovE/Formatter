package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * Context implements.
 */
public class Context implements IContext {

    private int indent = 0;

    @Override
    public void writeLexeme(final IToken token, final IWriter writer) throws WriterException {
        writer.write(token.getLexeme());
    }

    @Override
    public void writeNewLine(final IWriter writer) throws WriterException {
        writer.write("\n");
    }

    @Override
    public void writeIndent(final IWriter writer) throws WriterException {
        final int indentSize = 4;
        try {
            for (int i = 0; i < indent * indentSize; i++) {
                writer.write(" ");
            }
        } catch (WriterException e) {
            throw new WriterException("Method writeIndent failed", e);
        }
    }

    @Override
    public void incrementIndent() {
        indent++;
    }

    @Override
    public void decrementIndent() {
        indent--;
    }
}
