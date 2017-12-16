package it.sevenbits.formatter.implementation.statemachine.command.newLineState;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.core.ICommand;
import it.sevenbits.formatter.implementation.statemachine.core.IContext;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * New line command implements in new line state.
 */
public class NewLineNewLineCommand implements ICommand {
    @Override
    public void execute(final IToken token, final IWriter writer, final IContext context) throws WriterException {
        context.writeNewLine(writer);
    }
}
