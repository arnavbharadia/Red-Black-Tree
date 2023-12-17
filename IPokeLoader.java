import java.io.FileNotFoundException;
import java.util.List;

/**
 * Instances of this interface can be used to load Pokemon data from a XML file.
 */
public interface IPokeLoader {

    /**
     * This method loads the list of Pokemon from a XML file.
     * @param filepathToXML path to the CSV file relative to the executable
     * @return a list of Pokemon objects
     * @throws FileNotFoundException
     */
    List<IPokemon> loadPokemon(String filepathToXML) throws FileNotFoundException;

}