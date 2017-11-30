package it.sevenbits.formatter.implementation.statemachine;

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
     * @param writer Input interface FileWriter.
     * @throws WriterException Failed or interrupted I/O operations.
     */
    void execute(IToken token, IWriter writer, IContext context) throws WriterException;
}
