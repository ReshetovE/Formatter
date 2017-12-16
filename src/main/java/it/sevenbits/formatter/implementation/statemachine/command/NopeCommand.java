package it.sevenbits.formatter.implementation.statemachine.command;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.core.ICommand;
import it.sevenbits.formatter.implementation.statemachine.core.IContext;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * Space command implements.
 */
public class NopeCommand implements ICommand {
    @Override
    public void execute(final IToken token, final IWriter writer, final IContext context) throws WriterException {

    }
}
