package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.lexer.statemachine.core.ICommandLexer;
import it.sevenbits.formatter.lexer.statemachine.core.LexerIContext;

/**
 * Slash command implements.
 */
public class AppendPostponeCommand implements ICommandLexer {

    @Override
    public void execute(final char c, final LexerIContext context) {
        context.appendPostpone(c);
    }
}
