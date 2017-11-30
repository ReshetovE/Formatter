package it.sevenbits.formatter.implementation.statemachine.command;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.ICommand;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * Space command implements.
 */
public class SpaceCommand implements ICommand {
    @Override
    public void execute(final IToken token, final IWriter writer) throws WriterException {

    }
}
