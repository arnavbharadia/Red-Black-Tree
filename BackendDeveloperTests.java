// --== CS400 Fall 2022 File Header Information ==--
// Name: Aidan Mulvaney
// Email: amulvaney@wisc.edu
// Team: CC Red
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: n/a

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BackendDeveloperTests extends PokeBackend {
    private PokeBackend integrationBackend = null;
    private PokeBackend individualBackend = null;
    private BackendPlaceholderPokeRBT placeholderRBT = new BackendPlaceholderPokeRBT();

    /**
     * Instantiates backends and RBTs needed for each test
     */
    @BeforeEach
    public void instantiateClasses() {
        integrationBackend = new PokeBackend();
        individualBackend = new PokeBackend(placeholderRBT);
    }

    /**
     * This test validates whether or not adding a Pokemon works correctly
     */
    @Test
    public void individualTest1() {
        // try adding poke1, see if can be found with getByID
        individualBackend.addPokemon(placeholderRBT.poke1);
        assertEquals(individualBackend.getByID(621), placeholderRBT.poke1);

        // try adding poke2, see if can be found with searchByHP
        individualBackend.addPokemon(placeholderRBT.poke2);
        assertEquals(individualBackend.seachByHP(50).get(0), placeholderRBT.poke2);
    }

    /**
     * This test validates whether or not the correct number of Pokemon is returned
     */
    @Test
    public void individualTest2() {
        // attempt to get number of Pokemon before and after adding a Pokemon
        assertEquals(individualBackend.getNumberPokemon(), 0);
        individualBackend.addPokemon(placeholderRBT.poke1);
        assertEquals(individualBackend.getNumberPokemon(), 1);
        individualBackend.addPokemon(placeholderRBT.poke2);
        assertEquals(individualBackend.getNumberPokemon(), 2);
    }

    /**
     * This test validates whether or not the set and get typeFilter method
     * functions as expected
     */
    @Test
    public void individualTest3() {
        // attempt to change the typeFilter, and verify that it is set correctly
        assertNull(individualBackend.getTypeFilter());
        individualBackend.setTypeFilter("water");
        assertEquals(individualBackend.getTypeFilter(), "water");
        individualBackend.setTypeFilter("dragon");
        assertEquals(individualBackend.getTypeFilter(), "dragon");
    }

    /**
     * This test validates whether or not the reset typeFilter works as expected
     */
    @Test
    public void individualTest4() {
        // attempt to reset the filter when there is no filter, and when there is a filter
        individualBackend.resetTypeFilter();
        assertNull(individualBackend.getTypeFilter());
        individualBackend.setTypeFilter("There are no typos in this sentence.");
        individualBackend.resetTypeFilter();
        assertNull(individualBackend.getTypeFilter());
    }

    /**
     * This test validates that searchByName works correctly, even when a typeFilter is set
     */
    @Test
    public void individualTest5() {
        individualBackend.addPokemon(placeholderRBT.poke1);
        individualBackend.addPokemon(placeholderRBT.poke2);

        // find a pokemon when no filter is set
        assertEquals(individualBackend.searchByName("Drudd").get(0), placeholderRBT.poke1);

        // find a pokemon when the correct filter is set
        individualBackend.setTypeFilter("dragon");
        assertEquals(individualBackend.searchByName("Drudd").get(0), placeholderRBT.poke1);

        // find a pokemon when the incorrect filter is set
        individualBackend.setTypeFilter("There is a typo in this sentence.");
        assertNull(individualBackend.searchByName("Drudd"));
    }

    /**
     * Validates whether adding Pokemon still works after integration
     */
    @Test
    public void integrationTest1() {
        Pokemon poke1 = new Pokemon("Bulbasaur", "45", "grass", "1");
        Pokemon poke2 = new Pokemon("Incineroar", "95", "fire", "727");
        Pokemon poke3 = new Pokemon("Magearna", "80", "steel", "801");

        integrationBackend.addPokemon(poke1);
        assertEquals(integrationBackend.getByID(1), poke1);
        integrationBackend.addPokemon(poke2);
        assertEquals(integrationBackend.searchByName("Incineroar").get(0), poke2);
        integrationBackend.addPokemon(poke3);
        assertEquals(integrationBackend.seachByHP(80).get(0), poke3);
        assertEquals(integrationBackend.getNumberPokemon(), 3);
    }

    /**
     * Validates whether the backend returns the correct Pokemon when
     * a typeFilter is and is not set after integration
     */
    @Test
    public void integrationTest2() {
        Pokemon poke1 = new Pokemon("Bulbasaur", "45", "grass", "1");
        Pokemon poke2 = new Pokemon("Incineroar", "95", "fire", "727");
        Pokemon poke3 = new Pokemon("Magearna", "80", "steel", "801");
        integrationBackend.addPokemon(poke1);
        integrationBackend.addPokemon(poke2);
        integrationBackend.addPokemon(poke3);

        // test with filter active
        integrationBackend.setTypeFilter("grass");
        assertEquals(integrationBackend.getTypeFilter(), "grass");
        assertNull(integrationBackend.searchByName("Incineroar"));
        assertEquals(integrationBackend.searchByName("Bulbasaur").get(0), poke1);

        // test with no filter
        integrationBackend.resetTypeFilter();
        assertNull(integrationBackend.getTypeFilter());
        assertEquals(integrationBackend.getByID(727), poke2);
    }

    /**
     * Validates that the validator works as expected 
     */
    @Test
    public void codeReviewOfAlgorithmEngineerTest1() {
        // test on valid input
        IPokeValidator validator = new AEIPokeValidator();
        assertTrue(validator.isValidPokedexID(1));
        assertTrue(validator.isValidPokedexID(801));
        assertTrue(validator.isValidPokedexID(621));

        // test on invalid input
        try {
            validator.isValidPokedexID(999);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "The ID should be an int between 1-801");
        }
        try {
            validator.isValidPokedexID(0);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "The ID should be an int between 1-801");
        }
        try {
            validator.isValidPokedexID(-1);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "The ID should be an int between 1-801");
        }
    }

    /**
     * Validate that the iterator correctly iterates through Pokemon in order of id
     */
    @Test
    public void codeReviewOfAlgorithmEngineerTest2() {
        // make a RBT
        Pokemon poke1 = new Pokemon("Bulbasaur", "45", "grass", "1");
        Pokemon poke2 = new Pokemon("Incineroar", "95", "fire", "727");
        Pokemon poke3 = new Pokemon("Magearna", "80", "steel", "801");
        IPokeRBT integrationRBT = new AEIPokeRBT();
        integrationRBT.insert(poke2);
        integrationRBT.insert(poke3);
        integrationRBT.insert(poke1);

        // test that iterating through it returns in pre order
        Pokemon[] pokemonArray = {poke1, poke2, poke3};
        int i = 0;
        for (IPokemon pokemon : integrationRBT) {
            assertEquals(pokemon, pokemonArray[i]);
            i++;
        }
    }
}