package it.sevenbits.formatter;

import it.sevenbits.formatter.core.*;
import it.sevenbits.formatter.file_io.*;
import it.sevenbits.formatter.implementation.*;

/**
 * Main implementation.
 */
public class Main {

    /**
     Start point to program.
     * @param args command line args, ignored.
     */
    public static void main(final String[] args) {
        try(
            IFormatter format = new Formatter();
            IReader in = new FileReader(args[0]);
            IWriter out = new FileWriter(args[1])){
            format.format(in, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
