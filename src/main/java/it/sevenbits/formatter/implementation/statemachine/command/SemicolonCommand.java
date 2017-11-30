package it.sevenbits.formatter.implementation.statemachine.command;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.ICommand;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;

/**
 * Semicolon command implements.
 */
public class SemicolonCommand implements ICommand {
    private StringBuilder stringBuilder;

    /**
     * Constructor class.
     */
    public SemicolonCommand() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public void execute(final IToken token, final IWriter writer) throws WriterException {
        stringBuilder.append(token.getLexeme());
        stringBuilder.append("\n");

        writer.write(String.valueOf(stringBuilder));
    }
}
