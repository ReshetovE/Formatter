package it.sevenbits.formatter.implementation;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.sevenbits.formatter.implementation.core.FormatterConfigException;
import it.sevenbits.formatter.implementation.statemachine.CommandRepository;
import it.sevenbits.formatter.implementation.statemachine.StateTransitions;
import it.sevenbits.formatter.implementation.statemachine.core.ICommand;
import it.sevenbits.formatter.implementation.statemachine.core.ICommandRepository;
import it.sevenbits.formatter.implementation.statemachine.core.IStateTransitions;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Parse formatter config file.
 */
public class FormatterConfig {

    private static ICommandRepository commands;
    private static IStateTransitions transitions;

    /**
     * Constructor formatter config class.
     */
    public FormatterConfig() throws FormatterConfigException {
        commands = new CommandRepository();
        transitions = new StateTransitions();

        InputStream file = Formatter.class.getResourceAsStream("/formatter.json");
        Gson gson = new Gson();
        JsonArray states = gson.fromJson(new InputStreamReader(file), JsonArray.class);
        for (JsonElement state : states) {
            JsonObject stateObject = state.getAsJsonObject();
            String currentStateName = stateObject.get("State").getAsString();
            JsonArray actions = stateObject.getAsJsonArray("Actions");
            for (JsonElement action: actions) {
                JsonObject actionObject = action.getAsJsonObject();

                String input = actionObject.get("Input").getAsString();
                String newState = actionObject.get("State").getAsString();
                String command = actionObject.get("Command").getAsString();

                transitions.insert(currentStateName, input, newState);
                commands.insert(currentStateName, input, createCommand(command));
            }
        }
    }

    private ICommand createCommand(final String nameCommand) throws FormatterConfigException {
        ICommand command = null;
        String fullName = "it.sevenbits.formatter.implementation.statemachine.command." + nameCommand;
        try {
            command = (ICommand) Class.forName(fullName).newInstance();
        } catch (Exception e) {
            throw new FormatterConfigException("Error when creating commands", e);
        }
        return command;
    }

    /**
     * Get map command.
     * @return Command.
     */
    public ICommandRepository getCommand() {
        return commands;
    }

    /**
     * Get map state.
     * @return State.
     */
    public IStateTransitions getState() {
        return transitions;
    }
}
