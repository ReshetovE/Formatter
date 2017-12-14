package it.sevenbits.formatter.lexer.statemachine.core;

/**
 * Command interface.
 */
public interface LexerICommand {

    /**
     * Command method.
     * @param c Char.
     * @param context Collection methods for token.
     */
    void execute(char c, LexerIContext context);
}
