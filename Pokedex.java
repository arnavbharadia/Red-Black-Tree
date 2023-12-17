// --== CS400 Fall 2022 File Header Information ==--
// Name: Aidan Mulvaney
// Email: amulvaney@wisc.edu
// Team: CC Red
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: n/a

import java.util.List;
import java.util.Scanner;

/**
 * the main entry point for the program
 */
public class Pokedex {

    /**
     * main method for the main entry point. instantiates all neccesary classes
     * for the program to work
     * @param args unused
     */
    public static void main(String[] args) {
        // load Pokemon from the xml file
        List<IPokemon> listOfPokemon = null;
        try {
            listOfPokemon = new PokeLoader().loadPokemon("pokemon.xml");
        } catch (Exception e) {
            // if the file cant be found, return.
            return;
        }
        
        // create backend
        IPokeBackend backend = new PokeBackend();

        // add each Pokemon to the backend, and the internal RBT
        for (IPokemon p : listOfPokemon) {
             backend.addPokemon(p);
        }

        // create validator for the frontend
        IPokeValidator validator = new AEIPokeValidator();

        // create scanner for the frontend
        Scanner userScnr = new Scanner(System.in);

        // create frontend
        IPokeFrontend frontend = new PokeFrontend(userScnr, backend, validator);

        // run the frontend command loop
        frontend.runCommandLoop();

        userScnr.close();
    }
}