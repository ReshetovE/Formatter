package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.implementation.Token;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.string_io.StringReader;
import it.sevenbits.formatter.lexer.statemachine.CommandRepositoryLexer;
import it.sevenbits.formatter.lexer.statemachine.LexerContext;
import it.sevenbits.formatter.lexer.statemachine.ICommandLexer;
import it.sevenbits.formatter.lexer.statemachine.ICommandRepositoryLexer;

/**
 * Lexical analyzer.
 */
public class Lexer implements ILexer, it.sevenbits.formatter.lexer.statemachine.LexerIContext {

    private final IReader reader;
    private StringBuilder tokenLexeme;
    private String tokenName;
    private ICommandRepositoryLexer commands;
    private IStateTransitionsLexer transitions;
    private it.sevenbits.formatter.lexer.statemachine.LexerIContext context;
    private StringBuilder postponeBuffer = new StringBuilder();


    /**
     * Constructor Lexer.
     * @param reader Reader.
     */
    public Lexer(final IReader reader) {
        this(reader, new CommandRepositoryLexer(), new StateTransitionsLexer());
    }

    /**
     * Constructor for testing.
     * @param reader Reader.
     * @param commands Command repository.
     * @param transitions State transitions.
     */
    public Lexer(final IReader reader, final ICommandRepositoryLexer commands, final IStateTransitionsLexer transitions) {
        this.reader = reader;
        this.commands = commands;
        this.transitions = transitions;
    }

    @Override
    public IToken readToken() throws LexerException {
        tokenLexeme = new StringBuilder();
        context = new LexerContext();
        State state = new State("default");
        IReader postponeReader = new StringReader(postponeBuffer.toString());
        try {

            while (postponeReader.hasNextChars() && state != null) {
                char c = postponeReader.readChar();
                ICommandLexer command = commands.getCommand(state, c);
                command.execute(c, this);
                state = transitions.getNextState(state, c);

            }
            postponeBuffer = new StringBuilder();

            while (reader.hasNextChars() && state != null) {
                char c = reader.readChar();
                ICommandLexer command = commands.getCommand(state, c);
                command.execute(c, this);
                state = transitions.getNextState(state, c);

            }

            return new Token(tokenName, tokenLexeme.toString());

        } catch (Exception e) {
            throw new LexerException("Method readToken failed", e);
        }
    }



    @Override
    public boolean hasMoreTokens() throws LexerException {
        try {
            return postponeBuffer.length() > 0 || reader.hasNextChars();
        } catch (Exception e) {
            throw new LexerException("Failed or interrupted I/O operations", e);
        }
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
}
