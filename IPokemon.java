/**
 * This interface defines getter methods for each Pokemon's data attributes
 * and is implemented by classes that represent a Pokemon and its associated
 * data.
 */
public interface IPokemon extends Comparable<IPokemon> {

    /**
     * Returns the name of the Pokemon.
     * @return name of the Pokemon
     */
    String getName();

    /**
     * Returns the HP of this pokemon as an int
     * @return int that is the HP
     */
    String getHP();

    /**
     * Returns the primary type of this Pokemon in a string
     * @return the primary type of this Pokemon
     */
    String getType();



    /**
     * Returns the Pokemon ID number that uniquely identifies this Pokemon.
     * @return Pokemon ID number as an int
     */
    String getID();

    public int compareTo(IPokemon p);

}
