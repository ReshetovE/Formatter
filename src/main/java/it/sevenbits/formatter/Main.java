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
     * "Throw" - part of the contract.
     * @throws ReaderException throws ReaderException.
     * @throws FormatterException throws FormatterException.
     * @throws WriterException throws WriterException.
     */
    public static void main(final String[] args) throws ReaderException, FormatterException, WriterException {
        IFormatter format = new Formatter();
        IReader in = new FileReader(args[0]);
        IWriter out = new FileWriter(args[1]);
        format.format(in, out);
        out.close();
        in.close();
    }
}
