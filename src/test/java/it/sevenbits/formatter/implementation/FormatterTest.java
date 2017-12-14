package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.implementation.core.FormatterException;
import it.sevenbits.formatter.implementation.core.IFormatter;
import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.string_io.StringReader;
import it.sevenbits.formatter.io.string_io.StringWriter;
import it.sevenbits.formatter.lexer.ILexer;
import it.sevenbits.formatter.lexer.Lexer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

    @Test
    public void testSimpleFormat() throws FormatterException {
        IReader reader = new StringReader(
                "a;   b"
        );
        IWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);

        IFormatter formatter = new Formatter();
        formatter.format(lexer, writer);
        assertEquals("a;\nb", writer.toString());
    }

    @Test
    public void testSemicolon() throws FormatterException {
        IReader reader = new StringReader(
                "sdfsdf;dfsd"
        );
        IWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);

        IFormatter formatter = new Formatter();
        formatter.format(lexer, writer);
        assertEquals("sdfsdf;\ndfsd", writer.toString());
    }

    @Test
    public void testOpenBrackets() throws FormatterException {
        IReader reader = new StringReader(
                "abc{ public;}"
        );
        IWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);

        IFormatter formatter = new Formatter();
        formatter.format(lexer, writer);
        assertEquals("abc{\n    public;\n}", writer.toString());
    }
}
