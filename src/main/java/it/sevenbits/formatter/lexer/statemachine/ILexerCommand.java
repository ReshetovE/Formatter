package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;

/**
 * Interface lexer command.
 */
public interface ILexerCommand {

    /**
     * Create token.
     * @param c lexeme.
     * @return Done token.
     */
    IToken execute(char c);
}
