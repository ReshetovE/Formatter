package it.sevenbits.formatter.implementation.statemachine.core;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * Context interface.
 */
public interface IContext {

    /**
     * Method write lexeme.
     * @param token Token for write.
     * @param writer Input interface FileWriter.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void writeLexeme(IToken token, IWriter writer) throws WriterException;

    /**
     * Method write new line.
     * @param writer Input interface FileWriter.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void writeNewLine(IWriter writer) throws WriterException;

    /**
     * Insert space method.
     * @param writer Input interface FileWriter.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void writeIndent(IWriter writer) throws WriterException;

    /**
     * Method increment indent.
     */
    void incrementIndent();

    /**
     * Method decrement indent.
     */
    void decrementIndent();

}
