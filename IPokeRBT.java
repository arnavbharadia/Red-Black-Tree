import java.util.Iterator;

public interface IPokeRBT extends Iterable<IPokemon> {
    /**
     * Inserts a new element into the tree.
     */
    public boolean insert(IPokemon data) throws NullPointerException, IllegalArgumentException;

    /**
     * Checks if the tree contains the given element.
     * @return true if the element is in the tree, false otherwise.
     */
    public boolean contains(IPokemon data);

    /**
     * Returns the number of elements in the tree.
     * @return the number of elements in the tree.
     */
    public int size();

    /**
     * Checks if the tree is empty.
     * @return true if the tree is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Returns the tree as a string.
     * @return the tree as a string.
     */
    public String toString();

    /**
     * Iterates through the tree in order.
     */
    public Iterator<IPokemon> iterator();

}
