package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.implementation.statemachine.Context;
import it.sevenbits.formatter.implementation.statemachine.ICommand;
import it.sevenbits.formatter.implementation.statemachine.IContext;
import it.sevenbits.formatter.implementation.statemachine.command.SpaceCommand;
import it.sevenbits.formatter.io.core_io.IWriter;
import it.sevenbits.formatter.io.core_io.WriterException;
import it.sevenbits.formatter.io.string_io.StringWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpaceCommandTest {

    @Test
    public void testSimple() throws WriterException {
        IWriter writer = new StringWriter();
        IToken token = mock(IToken.class);
        IContext context = new Context();
        when(token.getLexeme()).thenReturn("   ");
        ICommand command = new SpaceCommand();
        command.execute(token, writer, context);

        assertEquals("", writer.toString());
    }
}
