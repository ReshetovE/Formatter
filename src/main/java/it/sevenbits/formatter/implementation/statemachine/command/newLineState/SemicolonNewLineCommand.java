package it.sevenbits.formatter.implementation.statemachine.command.newLineState;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.core.ICommand;
import it.sevenbits.formatter.implementation.statemachine.core.IContext;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * Implements semicolon command in new line state.
 */
public class SemicolonNewLineCommand implements ICommand {

    @Override
    public void execute(final IToken token, final IContext context) throws WriterException {
        context.writeNewLine();
        context.writeIndent();
        context.writeLexeme(token);
    }
}
