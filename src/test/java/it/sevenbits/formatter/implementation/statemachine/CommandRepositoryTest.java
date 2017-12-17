package it.sevenbits.formatter.implementation.statemachine;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.core.ICommand;
import it.sevenbits.formatter.implementation.statemachine.command.NopeCommand;
import it.sevenbits.formatter.implementation.statemachine.core.ICommandRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommandRepositoryTest {

    @Test
    public void testTransferCommand() {
        ICommandRepository commandRepository = new CommandRepository();

        ICommand command;
        IToken token = mock(IToken.class);
        when(token.getName()).thenReturn("Space");

        command = commandRepository.getCommand(new State("NewLineState"), token);

        assertNotEquals(command, new NopeCommand());
    }
}
