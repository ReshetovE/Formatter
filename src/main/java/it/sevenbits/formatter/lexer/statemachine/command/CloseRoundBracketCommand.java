package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.lexer.statemachine.core.ILexerCommand;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerContext;

/**
 * Close round bracket command.
 */
public class CloseRoundBracketCommand implements ILexerCommand {

    @Override
    public void execute(final char c, final ILexerContext context) {
        context.appendLexeme(c);
        context.setTokenName("CloseRoundBracket");
    }
}
