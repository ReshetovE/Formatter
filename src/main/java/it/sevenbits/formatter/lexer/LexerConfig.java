package it.sevenbits.formatter.lexer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
                Character input = actionObject.get("Input").getAsCharacter();
                String command = actionObject.get("Command").getAsString();
                String newStateName = actionObject.get("State").getAsString();

                System.out.println(input + " " + command + " " + newStateName);

                transitions.insert(currentStateName, input, createState(newStateName));
                commands.insert(currentStateName, input, createCommand(command));
            }
        }
    }

    private State createState(final String newStateName) {
        return new State(newStateName);
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

    /*{
        "Input": "\u0000",
        "State": "Default",
        "Command": "OpenBracketCommand"
      },
      */

