package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.lexer.statemachine.core.ICommandLexer;
import it.sevenbits.formatter.lexer.statemachine.core.LexerIContext;

/**
 * Single line comment command implements.
 */
public class SingleLineCommentCommand implements ICommandLexer {

    @Override
    public void execute(final char c, final LexerIContext context) {
        context.appendLexeme(c);
        context.setTokenName("SingleLineComment");
    }
}
