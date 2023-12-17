import java.util.List;

public interface IPokeFrontend {
    /**
     * The constructor that the implementation this interface will
     * provide. It takes the Scanner that will read user input as
     * a parameter as well as the backend and the IPokeValidator.
     */
    //IPokeFrontend(Scanner userInputScanner, IPokeBackend backend, IPokeValidator validator)

    /**
     * This method starts the command loop for the frontend, and will
     * terminate when the user exists the app.
     */
    public void runCommandLoop();

    // to help make it easier to test the functionality of this program,
    // the following helper methods will help support runCommandLoop():

    public void displayMainMenu(); // prints command options to System.out

    public void displayPokemon(List<IPokemon> pokemons); // displays a list of Pokemons

    public void pokeIDLookup(); // reads Pokemon ID from System.in, displays results

    public void pokeNameLookup(); // reads Pokemon name from System.in, displays results

    public void pokeHPLookup(); // reads HP of Pokemon from System.in, displays results

    public void pokeTypeLookup(); // reads Type1 (primary) of Pokemon from System.in, displays results


}
