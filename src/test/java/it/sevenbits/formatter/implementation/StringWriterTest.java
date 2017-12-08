package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;
import it.sevenbits.formatter.io.string_io.StringWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringWriterTest {

    @Test
    public void testSimpleWrite() throws WriterException {
        IWriter writer = new StringWriter();

        writer.write("abc");
        assertEquals("abc", writer.toString());
    }

    @Test
    public void testSecondSimpleWrite() throws WriterException {
        IWriter writer = new StringWriter();

        writer.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", writer.toString());
    }
}
