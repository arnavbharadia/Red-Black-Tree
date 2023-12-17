// --== CS400 Fall 2022 File Header Information ==--
// Name: Aidan Mulvaney
// Email: amulvaney@wisc.edu
// Team: CC Red
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: n/a

import java.util.List;

/**
 * Instances of this interface implement the search and filter
 * functionality of the Red Black Pokedex app using red black trees.
 */
public interface IPokeBackend {

    /**
     * Adds a new Pokemon to the backend's database and is stored
     * in a red black tree internally.
     * @param pokemon the Pokemon to add
     */
    public void addPokemon(IPokemon pokemon);

    /**
     * Returns the number of Pokemon stored in the database
     * @return the number of Pokemon
     */
    public int getNumberPokemon();

    /**
     * This method can be used to set a filter for the author names
     * contained in the search results. A Pokemon is only returned as
     * a result for a search by Name or HP, but also must contain the 
     * string typeFilter, which must be contained in the Pokemon's type.
     * @param typeFilter the string that the Pokemon's type must contain
     */
    public void setTypeFilter(String typeFilter);

    /**
     * Returns the string used as the Type Filter, null if no Type filter currently set
     * @return the string used as the Type Filter, or null if none is set
     */
    public String getTypeFilter();

    /**
     * Resets the Type Filter to null
     */
    public void resetTypeFilter();

    /**
     * Search through all Pokemon in the database and return those Pokemon
     * whose name contains the string name. Each Pokemon must also satisfy the
     * Type Filter, if there is one.
     * @param name the string that must be contained within the name of the Pokemon
     * @return list of Pokemon found
     */
    public List<IPokemon> searchByName(String name);

    /**
     * Search through all Pokemon in the database and return those Pokemon
     * whose hp level matches the int hp. Each Pokemon must also satisfy the
     * Type Filter, if there is one.
     * @param hp the hp level that the Pokemon must have
     * @return list of Pokemon found
     */
    public List<IPokemon> seachByHP(int hp);

    /**
     * Return the Pokemon uniquely identified by the ID, or null if the ID is not present in the Pokedex.
     * @param id the Pokemon's Pokedex ID
     * @return the Pokemon associated by the ID, or null if the ID is not in the Pokedex.
     */
    public IPokemon getByID(int id);

}