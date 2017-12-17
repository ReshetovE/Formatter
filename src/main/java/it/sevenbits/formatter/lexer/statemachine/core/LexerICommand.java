package it.sevenbits.formatter.lexer.statemachine.core;

/**
 * Interface lexer command.
 */
public interface LexerICommand {

    /**
     * Create token.
     * @param c lexeme.
     * @param context Context.
     */
    void execute(char c, LexerIContext context);
}
