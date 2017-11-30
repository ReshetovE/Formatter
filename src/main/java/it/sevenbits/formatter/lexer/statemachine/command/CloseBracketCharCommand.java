package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.implementation.Token;
import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.lexer.statemachine.ILexerCommand;

/**
 * Close brackets command implements.
 */
public class CloseBracketCharCommand implements ILexerCommand {

    @Override
    public IToken execute(final char c) {
        return new Token("CloseBracket", String.valueOf(c));
    }
}
