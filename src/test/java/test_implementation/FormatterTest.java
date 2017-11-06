package test_implementation;

import it.sevenbits.formatter.core.*;
import it.sevenbits.formatter.implementation.Formatter;
import it.sevenbits.formatter.string_io.StringReader;
import it.sevenbits.formatter.string_io.StringWriter;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FormatterTest {
    private IFormatter format = new Formatter();
    private StringWriter out = new StringWriter();
    private StringReader in = null;
    @Test
    public void TestBrackets() throws ReaderException, FormatterException, WriterException {
        in = new StringReader("fdfddfs;fdsf;fdsa;afd");
        format.format(in, out);
        String sample ="fdfddfs;\nfdsf;\nfdsa;\nafd";
        assertEquals("Error test of brackers", sample, out.getString());
    }

    @Test
    public void TestOpenBrace() throws ReaderException, FormatterException, WriterException {
        in = new StringReader("sfd{fsda{d;sf");
        format.format(in, out);
        String sample ="sfd{\n    fsda{\n        d;\n        sf";
        assertEquals("Error test of open brace", sample, out.getString());
    }

    @Test
    public void TestCloseBrace() throws ReaderException, FormatterException, WriterException {
        in = new StringReader("f{dfgdfg{dsf;}}");
        format.format(in, out);
        String sample ="f{\n    dfgdfg{\n        dsf;\n    }\n}\n";
        assertEquals("Error test of close brace", sample, out.getString());
    }
}
