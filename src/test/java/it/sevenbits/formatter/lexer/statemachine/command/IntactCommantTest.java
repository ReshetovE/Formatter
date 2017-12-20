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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntactCommantTest {

    @Test
    public void testSimpleIntactCommand() throws LexerException, LexerConfigException {
        IReader reader = new StringReader("a");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("a", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testSimpleSecondIntactCommand() throws LexerException, LexerConfigException {
        IReader reader = new StringReader("u");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("u", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }
}
