package it.sevenbits.formatter.implementation.statemachine.command;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.ICommand;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * Default command implements.
 */
public class DefaultCommand implements ICommand {

    @Override
    public void execute(final IToken token, final IWriter writer) throws WriterException {
        try {
            writer.write(token.getLexeme());
        } catch (WriterException e) {
            throw new WriterException("Method format failed", e);
        }
    }
}
