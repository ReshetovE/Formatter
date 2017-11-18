package it.sevenbits.formatter;


import it.sevenbits.formatter.core.IFormatter;
import it.sevenbits.formatter.core.ILexer;
import it.sevenbits.formatter.file_io.FileReader;
import it.sevenbits.formatter.file_io.FileWriter;
import it.sevenbits.formatter.implementation.Formatter;
import it.sevenbits.formatter.implementation.Lexer;

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
        try (FileReader in = new FileReader(args[0]);
            FileWriter out = new FileWriter(args[1])) {
            ILexer lexer = new Lexer(in);
            IFormatter format = new Formatter();
            format.format(lexer, out);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
