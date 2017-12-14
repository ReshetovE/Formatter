package it.sevenbits.formatter.lexer.statemachine;

/**
 * Interface for Context class.
 */
public interface LexerIContext {

    /**
     * Char append token.
     * @param c Char.
     */
    void appendLexeme(char c);


    /**
     * Assing to name token.
     * @param name Future name token.
     */
    void setTokenName(String name);

    /**
     * Char append post token.
     * @param c Char.
     */
    void appendPostpone(char c);
}
