package it.sevenbits.formatter.lexer.statemachine.command;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.string_io.StringReader;
import it.sevenbits.formatter.lexer.LexerConfig;
import it.sevenbits.formatter.lexer.core.ILexer;
import it.sevenbits.formatter.lexer.Lexer;
import it.sevenbits.formatter.lexer.core.LexerConfigException;
import it.sevenbits.formatter.lexer.core.LexerException;
import org.junit.Test;

import static org.junit.Assert.*;

public class SemicolonCommandTest {

    @Test
    public void testSimpleSemicolonCommand() throws LexerException, LexerConfigException {
        IReader reader = new StringReader(";");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Semicolon", token.getName());
        assertEquals(";", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testNotEqualsSemicolonCommand() throws LexerException, LexerConfigException {
        IReader reader = new StringReader(";");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertNotEquals("Char", token.getName());
        assertNotEquals("a", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }
}
