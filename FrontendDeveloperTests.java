import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FrontendDeveloperTests {

    protected PokeFrontend poke;
    protected TextUITester uiTester;


    /**
     * Test 1 - Test if main menu method is functioning as expected
     * Tester will only pass if the behaviour is displayed as expected
     */
    @Test
    public void test1(){
        uiTester = new TextUITester("\n");
        poke  = new PokeFrontend(new Scanner(System.in), new FrontendDeveloperPokeBackendPlaceholder(), new FrontendDeveloperPokeValidatorPlaceholder());
        poke.displayMainMenu();

        assertEquals("You are in the Main Menu:\n"+
                "\t1) List all Pokemons\n\t2) Search by Type\n"+
                "\t3) Search by HP\n\t4) Search by ID\n\t5) Exit Application\n", uiTester.checkOutput());

    }

    /**
     * Test 2 - Tests if application will exit+
     * Tester will only pass if the behaviour is displayed as expected
     */
    @Test
    public void test2(){
        uiTester = new TextUITester("5\n");
        poke  = new PokeFrontend(new Scanner(System.in), new FrontendDeveloperPokeBackendPlaceholder(), new FrontendDeveloperPokeValidatorPlaceholder());

        poke.runCommandLoop();
        assertEquals("Welcome to the Red Black Pokedex Application!\n" +
                "x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n" +
                "You are in the Main Menu:\n"+
                "\t1) List all Pokemons\n\t2) Search by Type\n"+
                "\t3) Search by HP\n\t4) Search by ID\n"+
                "\t5) Exit Application\nGoodbye!\n", uiTester.checkOutput());
    }

    /**
     * Test 3 - Tests displayPokemon method
     * Tester will only pass if the behaviour is displayed as expected
     */
    @Test
    public void test3(){
        uiTester = new TextUITester("\n");
        poke  = new PokeFrontend(new Scanner(System.in), new FrontendDeveloperPokeBackendPlaceholder(), new FrontendDeveloperPokeValidatorPlaceholder());

        List<IPokemon> pokemon = new ArrayList<>();
        pokemon.add(new FrontendDeveloperPokemonPlaceholder());

        poke.displayPokemon(pokemon);

        //Displays default Pokemon set by Placeholder class
        assertEquals("1. Name: Pika ID: 2 HP: 10 Type: Fire\n", uiTester.checkOutput());
    }

    /**
     * Test 4 - Tests pokeIDLookup method
     * Tester will only pass if the behaviour is displayed as expected
     */
    @Test
    public void test4(){
        uiTester = new TextUITester("44\n");
        poke  = new PokeFrontend(new Scanner(System.in), new FrontendDeveloperPokeBackendPlaceholder(), new FrontendDeveloperPokeValidatorPlaceholder());

        poke.pokeIDLookup();

        // Placeholder class has been set to false by default
        assertEquals("You are in the Search for ID Menu: \n" +
                "\tEnter a new integer for Pokemon HP to contain (empty for any): \n Invalid ID!\n", uiTester.checkOutput());

    }


    /**
     * Test 5 - Tests pokeHPlookup method
     * Tester will only pass if the behaviour is displayed as expected
     */
    @Test
    public void test5(){
        uiTester = new TextUITester("44\n");
        poke  = new PokeFrontend(new Scanner(System.in), new FrontendDeveloperPokeBackendPlaceholder(), new FrontendDeveloperPokeValidatorPlaceholder());

        poke.pokeHPLookup();

        //Returns default poke set by the Placeholder classes
        assertEquals("You are in the Search by HP menu: \n" +
                "\tEnter a new integer for Pokemon HP to contain (empty for any): \n" +
                "1. Name: Pika ID: 2 HP: 10 Type: Fire\n", uiTester.checkOutput());
    }

}
