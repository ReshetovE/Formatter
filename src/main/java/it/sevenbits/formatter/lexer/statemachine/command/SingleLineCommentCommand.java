package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.lexer.statemachine.core.ILexerCommand;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerContext;

/**
 * Single line comment command implements.
 */
public class SingleLineCommentCommand implements ILexerCommand {

    @Override
    public void execute(final char c, final ILexerContext context) {
        context.appendLexeme(c);
        context.setTokenName("SingleLineComment");
    }
}
