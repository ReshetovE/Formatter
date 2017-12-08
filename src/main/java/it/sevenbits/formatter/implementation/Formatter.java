package it.sevenbits.formatter.implementation;

import it.sevenbits.formatter.implementation.core.FormatterException;
import it.sevenbits.formatter.implementation.core.IFormatter;
import it.sevenbits.formatter.implementation.statemachine.CommandRepository;
import it.sevenbits.formatter.implementation.statemachine.Context;
import it.sevenbits.formatter.implementation.statemachine.ICommand;
import it.sevenbits.formatter.implementation.statemachine.IContext;
import it.sevenbits.formatter.implementation.statemachine.IState;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.implementation.statemachine.StateTransitions;
import it.sevenbits.formatter.lexer.ILexer;
import it.sevenbits.formatter.implementation.core.IToken;
import it.sevenbits.formatter.io.core_io.IWriter;

/**
 * Formatter implementation.
 */
public class Formatter implements IFormatter {

    /**
     * Method Formatter.
     * @param lexer Interface Lexer.
     * @param out Output interface FileReader.
     * @throws FormatterException ReaderException/WriterException.
     */
    public void format(final ILexer lexer, final IWriter out) throws FormatterException {

         IState state = new State("DefaultState");
         IContext context = new Context();
         CommandRepository commands = new CommandRepository();

         try {
             while (lexer.hasMoreTokens()) {
                 IToken token = lexer.readToken();

                 StateTransitions transitions = new StateTransitions();

                 ICommand command;
                 command = commands.getCommand(state, token);
                 command.execute(token, out, context);

                 transitions.nextState(state, token);
             }
         } catch (Exception e) {
             throw new FormatterException("Method format failed", e);
         }
    }
}
