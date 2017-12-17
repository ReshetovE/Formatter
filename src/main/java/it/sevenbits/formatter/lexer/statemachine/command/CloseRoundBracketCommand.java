package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.lexer.statemachine.core.LexerICommand;
import it.sevenbits.formatter.lexer.statemachine.core.LexerIContext;

/**
 * Close round bracket command.
 */
public class CloseRoundBracketCommand implements LexerICommand {

    @Override
    public void execute(final char c, final LexerIContext context) {
        context.appendLexeme(c);
        context.setTokenName("CloseRoundBracket");
    }
}
