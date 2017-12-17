package it.sevenbits.formatter.implementation.statemachine.command.defaultState;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.core.ICommand;
import it.sevenbits.formatter.implementation.statemachine.core.IContext;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * Close bracket command implements.
 */
public class CloseBracketCommand implements ICommand {

    @Override
    public void execute(final IToken token, final IContext context) throws WriterException {
        context.writeNewLine();
        context.decrementIndent();
        context.writeIndent();
        context.writeLexeme(token);
    }
}
