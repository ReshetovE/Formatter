package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.implementation.Token;
import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.lexer.statemachine.ILexerCommand;

/**
 * Open brackets command implements.
 */
public class OpenBracketCharCommand implements ILexerCommand {

    @Override
    public IToken execute(final char c) {
        return new Token("OpenBracket", String.valueOf(c)) ;
    }
}
