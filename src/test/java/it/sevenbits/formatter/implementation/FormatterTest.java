package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.io.core_io.IReader;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.string_io.StringReader;
import it.sevenbits.formatter.io.string_io.StringWriter;
import it.sevenbits.formatter.lexer.ILexer;
import it.sevenbits.formatter.lexer.Lexer;
import org.junit.Test;

public class FormatterTest {

    @Test
    public void testSimpleFormat() {
        IReader reader = new StringReader(
                "a;\n" +
                        "   b"
        );
        IWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);


    }
}
