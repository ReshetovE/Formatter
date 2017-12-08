package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.core_io.ReaderException;
import it.sevenbits.formatter.io.string_io.StringReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StringReaderTest {

    @Test
    public void testSimpleRead() throws ReaderException {
        IReader reader = new StringReader("abc");

        assertTrue(reader.hasNextChars());
        assertEquals('a', reader.readChar());
        assertTrue(reader.hasNextChars());
        assertEquals('b', reader.readChar());
        assertTrue(reader.hasNextChars());
        assertEquals('c', reader.readChar());
    }
}
