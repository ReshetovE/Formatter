package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.CommandRepository;
import it.sevenbits.formatter.implementation.statemachine.ICommand;
import it.sevenbits.formatter.implementation.statemachine.ICommandRepository;
import it.sevenbits.formatter.implementation.statemachine.IState;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.implementation.statemachine.command.NewLineCommand;
import it.sevenbits.formatter.implementation.statemachine.command.SpaceCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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

        assertSame(command, new SpaceCommand());
    }
}
