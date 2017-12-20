package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.string_io.StringReader;
import it.sevenbits.formatter.lexer.core.ILexer;
import it.sevenbits.formatter.lexer.Lexer;
import it.sevenbits.formatter.lexer.core.LexerException;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;

public class LexerTest {

    @Test
    public void testSimpleTokenize() throws LexerException {
        IReader reader = new StringReader(
                "c"
        );
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("c", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());

    }

//    @Test
//    public void testStateMachineLoop() throws LexerException, ReaderException {
//        IReader reader = new StringReader("a"); //mock(IReader.class);
////        when(reader.hasNextChars()).thenReturn(true, false);
////        when(reader.readChar()).thenReturn('a');
//
//        LexerICommand command = mock(LexerICommand.class);
//        LexerICommandRepository commands = mock(LexerICommandRepository.class);
//        when(commands.getCommand(any(State.class), anyChar())).thenReturn(command);
//
//        LexerIStateTransitions transitions = mock(LexerIStateTransitions.class);
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
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

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
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("a", token.getLexeme());

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
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

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
        IReader reader = new StringReader("a{ pu");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

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
        assertEquals(" ", token.getLexeme());

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

    @Test
    public void testSingleLineComment() throws LexerException {
        IReader reader = new StringReader("//abc");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("SingleLineComment", token.getName());
        assertEquals("//", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("a", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("b", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("c", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testStar() throws LexerException {
        IReader reader = new StringReader("*/");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("CloseMultiLineComment", token.getName());
        assertEquals("*/", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testStar1() throws LexerException {
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
    public void testForTest() throws LexerException {
        IReader reader = new StringReader("for(");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("ForLoops", token.getName());
        assertEquals("for", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("(", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testSecondForTest() throws LexerException {
        IReader reader = new StringReader("fo^");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("fo", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("^", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testCloseRoundBracket() throws LexerException {
        IReader reader = new StringReader("(a)");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("(", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("Char", token.getName());
        assertEquals("a", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("CloseRoundBracket", token.getName());
        assertEquals(")", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

    @Test
    public void testIgnoreStringLiteral() throws LexerException {
        IReader reader = new StringReader("\"\\\"\"");
        LexerConfig lexerConfig = new LexerConfig();
        ILexer lexer = new Lexer(reader, lexerConfig);

        assertTrue(lexer.hasMoreTokens());
        IToken token = lexer.readToken();
        assertEquals("StringLiteral", token.getName());
        assertEquals("\"", token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token = lexer.readToken();
        assertEquals("IgnoreStringLiteral", token.getName());
        assertEquals("\\\"", token.getLexeme());
        assertTrue(lexer.hasMoreTokens());

        token = lexer.readToken();
        assertEquals("StringLiteral", token.getName());
        assertEquals("\"", token.getLexeme());

        assertFalse(lexer.hasMoreTokens());
    }

//    @Test
//    public void testBigTest() throws LexerException {
//        IReader reader = new StringReader("*//*");
//        LexerConfig lexerConfig = new LexerConfig();
//        ILexer lexer = new Lexer(reader, lexerConfig);
//
//        assertTrue(lexer.hasMoreTokens());
//        IToken token = lexer.readToken();
//        assertEquals("CloseMultiLineComment", token.getName());
//        assertEquals("*/", token.getLexeme());
//
//        assertTrue(lexer.hasMoreTokens());
//        token = lexer.readToken();
//        assertEquals("OpenMultiLineComment", token.getName());
//        assertEquals("/*", token.getLexeme());
//
//        assertFalse(lexer.hasMoreTokens());
//    }

}
