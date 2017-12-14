package it.sevenbits.formatter.lexer.statemachine.core;

/**
 * Interface lexer command.
 */
public interface ICommandLexer {

    /**
     * Create token.
     * @param c lexeme.
     * @param context Context.
     */
    void execute(char c, LexerIContext context);
}
