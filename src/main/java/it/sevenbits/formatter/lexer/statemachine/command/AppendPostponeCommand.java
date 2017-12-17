package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.lexer.statemachine.core.LexerICommand;
import it.sevenbits.formatter.lexer.statemachine.core.LexerIContext;

/**
 * Slash command implements.
 */
public class AppendPostponeCommand implements LexerICommand {

    @Override
    public void execute(final char c, final LexerIContext context) {
        context.appendPostpone(c);
    }
}
