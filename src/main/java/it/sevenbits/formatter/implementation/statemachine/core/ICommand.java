package it.sevenbits.formatter.implementation.statemachine.core;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * Command interface.
 */
public interface ICommand {

    /**
     * Command method.
     * @param token Token interface.
     * @param context Collection methods for space.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void execute(IToken token, IContext context) throws WriterException;
}
