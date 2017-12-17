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
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void writeLexeme(IToken token) throws WriterException;

    /**
     * Method write new line.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void writeNewLine() throws WriterException;

    /**
     * Insert space method.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void writeIndent() throws WriterException;

    /**
     * Method increment indent.
     */
    void incrementIndent();

    /**
     * Method decrement indent.
     */
    void decrementIndent();

}
