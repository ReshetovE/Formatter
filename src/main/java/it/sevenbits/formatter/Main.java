package it.sevenbits.formatter;


import it.sevenbits.formatter.core.IFormatter;
import it.sevenbits.formatter.core.IReader;
import it.sevenbits.formatter.core.IWriter;
import it.sevenbits.formatter.file_io.FileReader;
import it.sevenbits.formatter.file_io.FileWriter;
import it.sevenbits.formatter.implementation.Formatter;

/**
 * Main implementation.
 */
public class Main {

    /**
     Start point to program.
     * @param args command line args, ignored.
     */
    public static void main(final String[] args) {
        try (IFormatter format = new Formatter();
            IReader in = new FileReader(args[0]);
            IWriter out = new FileWriter(args[1])) {
            format.format(in, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
