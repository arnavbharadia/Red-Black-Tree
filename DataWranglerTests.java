import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.FileNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class DataWranglerTests {

    /**
     * Test to ensure that a Pokemon instance can be created and the getHP method works along with testing the compareTo method
     */
    @Test
    public void test1() {
        Pokemon testPokemon = new Pokemon("Pikachu", "85", "Fire", "656");
        assertEquals(testPokemon.getHP(), "85");
        Pokemon testPokemon2 = new Pokemon("Pikachu", "85", "Fire", "657");
        assertEquals(testPokemon.compareTo(testPokemon2), -1);
    }

    /**
     * Test to ensure the pokeloader reads in all the Pokemon in the dataset by checking the length of the returned ArrayList.
     */
    @Test
    public void test2() {
        PokeLoader pokeLoader = new PokeLoader();
        try {
            List<IPokemon> pokemons = pokeLoader.loadPokemon("./pokemon.xml");
            assertEquals(pokemons.size(), 801);
        } catch (FileNotFoundException e) {
            assertEquals(1, 2);
        }
    }

    /**
     * Test to ensure the first element of the pokeloader is the actual first element and to test the getID method of the Pokemon class.
     */
    @Test
    public void test3() {
        PokeLoader pokeLoader = new PokeLoader();
        try {
            List<IPokemon> pokemons = pokeLoader.loadPokemon("./pokemon.xml");
            IPokemon firstPokemon = pokemons.get(0);
            assertEquals(firstPokemon.getID(), "1");
        } catch (FileNotFoundException e) {
            assertEquals(1, 2);
        }
    }

    /**
     * Test to ensure that the last element is the actual last element and to test the getName method of Pokemon.
     */
    @Test
    public void test4() {
        PokeLoader pokeLoader = new PokeLoader();
        try {
            List<IPokemon> pokemons = pokeLoader.loadPokemon("./pokemon.xml");
            IPokemon lastPokemon = pokemons.get(pokemons.size() - 1);
            assertEquals(lastPokemon.getName(), "Magearna");
        } catch (FileNotFoundException e) {
            assertEquals(1, 2);
        }
    }

    /**
     * Tests to ensure the loadPokemon method throws a FileNotFound exception when the file path is invalid.
     */
    @Test
    public void test5() {
        PokeLoader pokeLoader = new PokeLoader();
        FileNotFoundException thrown = assertThrows(FileNotFoundException.class, () -> {
            List<IPokemon> pokemons = pokeLoader.loadPokemon("./not pokemon.xml");
        });
        assertEquals("XML file could not be located", thrown.getMessage());
    }
}
