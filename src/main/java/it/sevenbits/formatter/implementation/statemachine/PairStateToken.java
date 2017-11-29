package it.sevenbits.formatter.implementation.statemachine;

/**
 * Pair class.
 * @param <IState> State interface.
 * @param <String> Token name string.
 */
public class PairStateToken {

    /**
     * State.
     */
    private IState state;

    /**
     * Token.
     */
    private String tokenName;

    /**
     * Constructor pair.
     * @param state State.
     * @param tokenName Token name.
     */
    PairStateToken(final IState state, final String tokenName) {
        this.state = state;
        this.tokenName = tokenName;
    }

    @Override
    public int hashCode() {
        return this.state.hashCode() + this.tokenName.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        PairStateToken elem = (PairStateToken) o;
        return this.tokenName.equals(elem.tokenName) &&
                this.state.equals(elem.state);
    }
}
