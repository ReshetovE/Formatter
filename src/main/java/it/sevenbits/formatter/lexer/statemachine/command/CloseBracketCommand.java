package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.lexer.statemachine.core.LexerICommand;
import it.sevenbits.formatter.lexer.statemachine.core.LexerIContext;

/**
 * Close bracket command implements.
 */
public class CloseBracketCommand implements LexerICommand {

    @Override
    public void execute(final char c, final LexerIContext context) {
        context.appendLexeme(c);
        context.setTokenName("CloseBracket");
    }
}
