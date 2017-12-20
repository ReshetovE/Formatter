package it.sevenbits.formatter;


import it.sevenbits.formatter.implementation.FormatterConfig;
import it.sevenbits.formatter.implementation.core.IFormatter;
import it.sevenbits.formatter.lexer.LexerFactory;
import it.sevenbits.formatter.io.file_io.FileReader;
import it.sevenbits.formatter.io.file_io.FileWriter;
import it.sevenbits.formatter.implementation.Formatter;

/**
 * Main implementation.
 */
public class Main {

    /**
     *Start point to program.
     *@param args command line args, ignored.
     *@throws Exception Exception.
     */

    public static void main(final String[] args) throws Exception {
        try (
            FileReader in = new FileReader(args[0]);
            FileWriter out = new FileWriter(args[1])
        ) {
            IFormatter format = new Formatter(new LexerFactory(), new FormatterConfig());
            format.format(in, out);
        }
    }
}
