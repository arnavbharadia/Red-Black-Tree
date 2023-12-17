import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokeFrontend implements IPokeFrontend{
    private Scanner userInputScanner;
    private IPokeBackend backend;
    private IPokeValidator validator;

    /**
     * The constructor that the implementation this interface will
     * provide. It takes the Scanner that will read user input as
     * a parameter as well as the backend and the IPokeValidator.
     */
     PokeFrontend(Scanner userInputScanner, IPokeBackend backend, IPokeValidator validator) {
        this.userInputScanner = userInputScanner;
        this.backend = backend;
        this.validator = validator;
    }


    /**
     * This method starts the command loop for the frontend, and will
     * terminate when the user exists the app.
     */
    @Override
    public void runCommandLoop() {
        System.out.print("Welcome to the Red Black Pokedex Application!\n");
        System.out.print("x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x+x\n");
        while (true) {
            displayMainMenu();
            int option = userInputScanner.nextInt();
            userInputScanner.nextLine(); // move past the new line created after int
            if (option == 1) {
                List<IPokemon> Pokemon = backend.searchByName("");
                System.out.print("Listing All Pokemons... \n");
                displayPokemon(Pokemon);
            }
            else if (option == 2) {
                pokeTypeLookup();
            }
            else if (option == 3) {
                pokeHPLookup();
            }
            else if (option == 4) {
                pokeIDLookup();
            }
            else if (option == 5) {
                System.out.print("Goodbye!\n");
                return;
            }
            else {
                // Do Nothing
            }

        }

    }

    @Override
    public void displayMainMenu() {
        System.out.print("You are in the Main Menu:\n");
        System.out.print("\t1) List all Pokemons\n\t2) Search by Type\n");
        System.out.print("\t3) Search by HP\n\t4) Search by ID\n\t5) Exit Application\n");
    }

    @Override
    public void displayPokemon(List<IPokemon> pokemons) {
        int count = 1;
        for (IPokemon pokemon: pokemons ){
            System.out.print(count +  ". " + prnt(pokemon));
            count++;
        }
    }

    @Override
    public void pokeIDLookup() {
        System.out.print("You are in the Search for ID Menu: \n");
        System.out.print("\tEnter a new integer for Pokemon HP to contain (empty for any): ");
        int ID = userInputScanner.nextInt();
        userInputScanner.nextLine();

        System.out.print("\n ");

        if(validator.isValidPokedexID(ID)){
            if(backend.getByID(ID) == null){
                System.out.print("ID doesn't exist in the database!\n");
            }
            else{
                List<IPokemon> pokemons = new ArrayList<>();
                pokemons.add(backend.getByID(ID));
                displayPokemon(pokemons);
            }
        }
        else{
            System.out.print("Invalid ID!\n");
        }
    }

    @Override
    public void pokeNameLookup() {
        return;
    }

    @Override
    public void pokeHPLookup() {
        System.out.print("You are in the Search by HP menu: \n");

        System.out.println("\tEnter a new integer for Pokemon HP to contain (empty for any): ");
        int HP = userInputScanner.nextInt();
        userInputScanner.nextLine();

        List<IPokemon> pokemons = backend.seachByHP(HP);
        displayPokemon(pokemons);

    }

    @Override
    public void pokeTypeLookup() {
        System.out.print("You are in the Search by Type Menu: \n");
        System.out.print("\tEnter a Type to filter Pokemons by (empty for any): ");
        String Type = userInputScanner.nextLine();

       backend.setTypeFilter(Type);

       if(Type.equals("")){
           System.out.print("No Filter's applied\n");
           backend.resetTypeFilter();
           return;
       }
    }

    private String prnt(IPokemon poke){
        return "Name: " + poke.getName() + " ID: " + poke.getID() + " HP: " + poke.getHP() + " Type: " + poke.getType() + "\n";
    }

}
