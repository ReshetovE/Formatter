package it.sevenbits.formatter.lexer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import it.sevenbits.formatter.implementation.statemachine.State;
import it.sevenbits.formatter.lexer.statemachine.LexerCommandRepository;
import it.sevenbits.formatter.lexer.statemachine.LexerStateTransitions;
import it.sevenbits.formatter.lexer.statemachine.core.LexerICommand;
import it.sevenbits.formatter.lexer.statemachine.core.LexerICommandRepository;
import it.sevenbits.formatter.lexer.statemachine.core.LexerIStateTransitions;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Parse config file.
 */
public class LexerConfig {

    private static LexerICommandRepository commands;
    private static LexerIStateTransitions transitions;

    /**
     * Constructor lexer config.
     */
    public LexerConfig() {
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
    private LexerICommand createCommand(final String nameCommand)  {
        LexerICommand command = null;
                String fullName = "it.sevenbits.formatter.lexer.statemachine.command." + nameCommand;
        try {
            command = (LexerICommand) Class.forName(fullName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return command;
    }

    /**
     * Get map command.
     * @return Command.
     */
    public LexerICommandRepository getCommand() {
        return commands;
    }

    /**
     * Get map state.
     * @return State.
     */
    public LexerIStateTransitions getState() {
        return transitions;
    }
}


