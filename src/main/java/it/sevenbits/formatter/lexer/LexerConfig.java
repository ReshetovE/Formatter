package it.sevenbits.formatter.lexer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.core.LexerConfigException;
import it.sevenbits.formatter.lexer.statemachine.LexerCommandRepository;
import it.sevenbits.formatter.lexer.statemachine.LexerStateTransitions;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerCommand;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerCommandRepository;
import it.sevenbits.formatter.lexer.statemachine.core.ILexerStateTransitions;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Parse lexer config file.
 */
public class LexerConfig {

    private static ILexerCommandRepository commands;
    private static ILexerStateTransitions transitions;

    /**
     * Constructor lexer config.
     */
    public LexerConfig() throws LexerConfigException {
        commands = new LexerCommandRepository();
        transitions = new LexerStateTransitions();

        InputStream file = Lexer.class.getResourceAsStream("/lexer.json");
        Gson gson = new Gson();
        JsonArray states = gson.fromJson(
                new InputStreamReader(file), JsonArray.class);
        for (JsonElement state : states) {
            JsonObject stateObject = state.getAsJsonObject();
            String currentStateName = stateObject.get("State").getAsString();
            JsonArray actions = stateObject.getAsJsonArray("Actions");
            for (JsonElement action: actions) {
                JsonObject actionObject = action.getAsJsonObject();

                boolean checkNullChar = actionObject.get("Input").isJsonNull();
                Character input;
                if (checkNullChar) {
                    input = null;
                } else {
                    input = actionObject.get("Input").getAsCharacter();
                }

                boolean checkNullState = actionObject.get("State").isJsonNull();
                State newState;
                if (checkNullState) {
                    newState = null;
                } else {
                    newState = new State(actionObject.get("State").getAsString());
                }

                String command = actionObject.get("Command").getAsString();

                transitions.insert(currentStateName, input, newState);
                commands.insert(currentStateName, input, createCommand(command));
            }
        }
    }

    /**
     * Create new command.
     * @param nameCommand Name class command.
     * @return New Command.
     */
    private ILexerCommand createCommand(final String nameCommand) throws LexerConfigException {
        ILexerCommand command = null;
                String fullName = "it.sevenbits.formatter.lexer.statemachine.command." + nameCommand;
        try {
            command = (ILexerCommand) Class.forName(fullName).newInstance();
        } catch (Exception e) {
            throw new LexerConfigException("Error when creating commands", e);
        }
        return command;
    }

    /**
     * Get map command.
     * @return Command.
     */
    public ILexerCommandRepository getCommand() {
        return commands;
    }

    /**
     * Get map state.
     * @return State.
     */
    public ILexerStateTransitions getState() {
        return transitions;
    }
}


