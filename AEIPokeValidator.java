// --== CS400 Fall 2022 File Header Information ==--
// Name: Arnav Bharadia
// Email: abharadia@wisc.edu
// Team: CC
// TA: Daniel
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

public class AEIPokeValidator implements IPokeValidator{

    /**
     * Checks if the given Pokemon has a valid Pokedex ID.
     *
     * @param id the Pokemon's ID to validate
     * @return true if the Pokedex ID is valid, false otherwise.
     */
    @Override public boolean isValidPokedexID(int id) throws IllegalArgumentException {
        //the ID should be an int between 1-801
        if (id < 1 || id > 801) {
            throw new IllegalArgumentException("The ID should be an int between 1-801");
        }
        return true;
    }
}
