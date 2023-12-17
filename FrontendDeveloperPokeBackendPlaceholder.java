import java.util.ArrayList;
import java.util.List;

public class FrontendDeveloperPokeBackendPlaceholder implements IPokeBackend{

    FrontendDeveloperPokeBackendPlaceholder(){

    }
    /**
     * Adds a new Pokemon to the backend's database and is stored
     * in a red black tree internally.
     *
     * @param pokemon the Pokemon to add
     */
    //@Override
    public void addPokemon(IPokemon pokemon) {
        return;
    }

    /**
     * Removes a Pokemon from the database and from the internal red black tree.
     *
     * @param id the ID of the Pokemon to remove
     * @return the Pokemon removed if successful, null otherwise
     */
   // @Override
    public IPokemon removePokemon(int id) {
        return null;
    }

    /**
     * Returns the number of Pokemon stored in the database
     *
     * @return the number of Pokemon
     */
    //@Override
    public int getNumberPokemon() {
        return 0;
    }

    /**
     * This method can be used to set a filter for the author names
     * contained in the search results. A Pokemon is only returned as
     * a result for a search by Name or HP, but also must contain the
     * string typeFilter, which must be contained in the Pokemon's type.
     *
     * @param typeFilter the string that the Pokemon's type must contain
     */
    //@Override
    public void setTypeFilter(String typeFilter) {
        return;

    }

    /**
     * Returns the string used as the Type Filter, null if no Type filter currently set
     *
     * @return the string used as the Type Filter, or null if none is set
     */
    //@Override
    public String getTypeFilter() {
        return null;
    }

    /**
     * Resets the Type Filter to null
     */
    //@Override
    public void resetTypeFilter() {
	return;
    }

    /**
     * Search through all Pokemon in the database and return those Pokemon
     * whose name contains the string name. Each Pokemon must also satisfy the
     * Type Filter, if there is one.
     *
     * @param name the string that must be contained within the name of the Pokemon
     * @return list of Pokemon found
     */
   /// @Override
    public List<IPokemon> searchByName(String name) {
        return null;
    }

    /**
     * Search through all Pokemon in the database and return those Pokemon
     * whose hp level matches the int hp. Each Pokemon must also satisfy the
     * Type Filter, if there is one.
     *
     * @param hp the hp level that the Pokemon must have
     * @return list of Pokemon found
     */
    //@Override
    public List<IPokemon> seachByHP(int hp) {
        List<IPokemon> poke = new ArrayList<>();
        poke.add(new FrontendDeveloperPokemonPlaceholder());
        return poke;
    }

    /**
     * Return the Pokemon uniquely identified by the ID, or null if the ID is not present in the Pokedex.
     *
     * @param id the Pokemon's Pokedex ID
     * @return the Pokemon associated by the ID, or null if the ID is not in the Pokedex.
     */
    //@Override
    public IPokemon getByID(int id) {
        return null;
    }
}

