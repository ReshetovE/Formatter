package test_implementation;

import it.sevenbits.formatter.core.*;
import it.sevenbits.formatter.implementation.Formatter;
import it.sevenbits.formatter.string_io.StringReader;
import it.sevenbits.formatter.string_io.StringWriter;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FormatterTest {

    @Test
    public void TestBrackets() throws ReaderException, FormatterException, WriterException {
        IFormatter format = new Formatter();
        StringReader in = new StringReader("fdfddfs;fdsf;fdsa;afd");
        StringWriter out = new StringWriter();
        format.format(in, out);
        String expected ="nullfdfddfs;\nfdsf;\nfdsa;\nafd";
        assertEquals("String formatting went wrong", expected, out.getString());
    }
}
