package it.sevenbits.formatter.implementation.lexer;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.core_io.ReaderException;
import it.sevenbits.formatter.io.string_io.StringReader;
import it.sevenbits.formatter.lexer.ILexer;
import it.sevenbits.formatter.lexer.statemachine.core.IStateTransitionsLexer;
import it.sevenbits.formatter.lexer.Lexer;
import it.sevenbits.formatter.lexer.LexerException;
import it.sevenbits.formatter.lexer.statemachine.core.ICommandLexer;
import it.sevenbits.formatter.lexer.statemachine.core.ICommandRepositoryLexer;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.*;

public class LexerTest {

    @Test
    public void testSimpleTokenize() throws LexerException {
        IReader reader = new StringReader(
                "a;\n" +
                        "   b"
        );
        ILexer lexer = new Lexer(reader);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("a", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Semicolon", token.getName());
        assertEquals(";", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("NewLine", token.getName());
        assertEquals("\n", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Space", token.getName());
        assertEquals("   ", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("b", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());

    }

//    @Test
//    public void testStateMachineLoop() throws LexerException, ReaderException {
//        IReader reader = new StringReader("it/sevenbits/formatter/implementation/a"); //mock(IReader.class);
////        when(reader.hasNextChars()).thenReturn(true, false);
////        when(reader.readChar()).thenReturn('a');
//
//        ICommandLexer command = mock(ICommandLexer.class);
//        ICommandRepositoryLexer commands = mock(ICommandRepositoryLexer.class);
//        when(commands.getCommand(any(State.class), anyChar())).thenReturn(command);
//
//        IStateTransitionsLexer transitions = mock(IStateTransitionsLexer.class);
//
//
//        ILexer lexer = new Lexer(reader, commands, transitions);
//        lexer.readToken();
//
////        verify(reader, times(2)).hasNextChars();
////        verify(reader).readChar();
//        verify(commands).getCommand(new State("default"), 'a');
//        verify(command).execute(eq('a'), any(Lexer.class));
//        verify(transitions).getNextState(new State("default"), 'a');
//    }

    @Test
    public void testOpenBracket() throws LexerException {
        IReader reader = new StringReader("a{p");
        ILexer lexer = new Lexer(reader);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("a", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("OpenBracket", token.getName());
        assertEquals("{", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("p", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testCloseBracket() throws LexerException {
        IReader reader = new StringReader("a}p");
        ILexer lexer = new Lexer(reader);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("it/sevenbits/formatter/implementation/a", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("CloseBracket", token.getName());
        assertEquals("}", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("p", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testSpace() throws LexerException {
        IReader reader = new StringReader("; b");
        ILexer lexer = new Lexer(reader);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Semicolon", token.getName());
        assertEquals(";", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Space", token.getName());
        assertEquals(" ", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("b", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testSpace2() throws LexerException {
        IReader reader = new StringReader("a{  pu");
        ILexer lexer = new Lexer(reader);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("a", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("OpenBracket", token.getName());
        assertEquals("{", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Space", token.getName());
        assertEquals("  ", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("p", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("u", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

}