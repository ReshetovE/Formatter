package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.IWriter;

/**
 * Command interface.
 */
public interface ICommand {

    /**
     * Command method.
     * @param token Token interface.
     * @param writer Input interface FileWriter.
     */
    void execute(IToken token, IWriter writer);
}
