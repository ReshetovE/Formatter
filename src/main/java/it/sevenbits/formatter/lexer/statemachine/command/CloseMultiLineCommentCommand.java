package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.lexer.statemachine.core.LexerICommand;
import it.sevenbits.formatter.lexer.statemachine.core.LexerIContext;

/**
 * Implements char command in single line comment state.
 */
public class CloseMultiLineCommentCommand implements LexerICommand {

    @Override
    public void execute(final char c, final LexerIContext context) {
        context.appendLexeme(c);
        context.setTokenName("CloseMultiLineComment");
    }
}
