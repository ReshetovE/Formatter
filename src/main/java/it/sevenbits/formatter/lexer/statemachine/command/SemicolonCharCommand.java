package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.implementation.Token;
import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.lexer.statemachine.ILexerCommand;

/**
 * Semicolon command implements.
 */
public class SemicolonCharCommand implements ILexerCommand {

    @Override
    public IToken execute(final char c) {
        return new Token("Semicolon", String.valueOf(c));
    }
}
