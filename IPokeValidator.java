/**
 * Implementations of this interface will verify if the id of the pokemon is correct or not,
 * so that the Frontend Developer can use it to validate user input.
 */
public interface IPokeValidator {

    /**
     * Checks if the given Pokemon has a valid Pokedex ID.
     * @param id the Pokemon's ID to validate
     * @return true if the Pokedex ID is valid, false otherwise.
     */
    public boolean isValidPokedexID(int id) throws IllegalArgumentException;
}

