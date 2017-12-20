package it.sevenbits.formatter.lexer.statemachine.core;

/**
 * Interface for Context class.
 */
public interface ILexerContext {

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

    /**
     * Getter token name.
     * @return String name.
     */
    String getTokenName();

    /**
     * Getter lexeme.
     * @return String builder lexeme.
     */
    StringBuilder getTokenLexeme();

    /**
     * Getter postpone lexeme.
     * @return String builder lexeme.
     */
    StringBuilder getPostponeBuffer();

    /**
     * Clear string builder.
     */
    void createNewLexeme();

    /**
     * Clear postpone string builder.
     */
    void createNewPostpone();

}
