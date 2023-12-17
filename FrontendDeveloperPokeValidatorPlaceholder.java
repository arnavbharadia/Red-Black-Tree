public class FrontendDeveloperPokeValidatorPlaceholder implements IPokeValidator{

    FrontendDeveloperPokeValidatorPlaceholder(){

    }
    /**
     * Checks if the given Pokemon has a valid Pokedex ID.
     *
     * @param id the Pokemon's ID to validate
     * @return true if the Pokedex ID is valid, false otherwise.
     */
    @Override
    public boolean isValidPokedexID(int id) throws IllegalArgumentException{
        return false;
    }
}
