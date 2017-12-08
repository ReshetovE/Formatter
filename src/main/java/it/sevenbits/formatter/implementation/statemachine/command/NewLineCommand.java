package it.sevenbits.formatter.implementation.statemachine.command;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.ICommand;
import it.sevenbits.formatter.implementation.statemachine.IContext;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * New line command implements
 */
public class NewLineCommand implements ICommand {
    @Override
    public void execute(final IToken token, final IWriter writer, final IContext context) throws WriterException {
        context.writeNewLine(writer);
    }
}
