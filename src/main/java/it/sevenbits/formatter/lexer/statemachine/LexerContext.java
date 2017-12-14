package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.lexer.statemachine.core.LexerIContext;

/**
 * Context implements.
 */
public class LexerContext implements LexerIContext {

    private String postponeTokenName;
    private String tokenName;
    private StringBuilder tokenLexeme;
    private StringBuilder postponeBuffer;

    /**
     * Constructor lexer context.
     */
    public LexerContext() {
        tokenName = "";
        tokenLexeme = new StringBuilder();
        postponeTokenName = "";
        postponeBuffer = new StringBuilder();
    }

    @Override
    public void appendLexeme(final char c) {
        tokenLexeme.append(c);
    }

    @Override
    public void setTokenName(final String name) {
        tokenName = name;
    }

    @Override
    public void appendPostpone(final char c) {
        postponeBuffer.append(c);
    }

    @Override
    public String getTokenName() {
        return tokenName;
    }

    @Override
    public StringBuilder getTokenLexeme() {
        return tokenLexeme;
    }

    @Override
    public StringBuilder getPostponeBuffer() {
        return postponeBuffer;
    }

    @Override
    public void createNewLexeme() {
        tokenLexeme = new StringBuilder();
    }

    @Override
    public void createNewPostpone() {
        postponeBuffer = new StringBuilder();
    }

    @Override
    public String getPostponeTokenName() {
        return postponeTokenName;
    }

    @Override
    public void setPostponeTokenName(final String name) {
        postponeTokenName = name;
    }
}
