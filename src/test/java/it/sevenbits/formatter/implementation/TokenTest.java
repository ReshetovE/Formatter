package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.implementation.core.IToken;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TokenTest {

    //Write 100% Code coverage! =D

    @Test
    public void testSimpleToken() {
        IToken token = new Token("Char", "it/sevenbits/formatter/implementation/a");

        assertEquals("Char", token.getName());
        assertEquals("it/sevenbits/formatter/implementation/a", token.getLexeme());
    }

    @Test
    public void testSecondSimpleToken() {
        IToken token = new Token("Semicolon", ";");

        assertEquals("Semicolon", token.getName());
        assertEquals(";", token.getLexeme());
    }
}
