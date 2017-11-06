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
        String expected ="nullfdfddfs;\nfdsf;\nfdsa;\nafd";
        assertEquals("String formatting went wrong", expected, out.getString());
    }

    @Test
    public void TestEnterSpace() throws ReaderException, FormatterException, WriterException {
        in = new StringReader("sfd{fsda{dsf");
        format.format(in, out);
        String expected ="nullsfd{\n    fsda{\n        dsf";
        assertEquals("String formatting went wrong", expected, out.getString());
    }
}
