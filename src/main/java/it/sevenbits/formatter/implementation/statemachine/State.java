package it.sevenbits.formatter.implementation.statemachine;

/**
 * Default state implements.
 */
public class State implements IState {

    private String name;

    State(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        return name != null ? name.equals(state.name) : state.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
