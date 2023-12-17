// --== CS400 Fall 2022 File Header Information ==--
// Name: Arnav Bharadia
// Email: abharadia@wisc.edu
// Team: CC
// TA: Daniel
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AlgorithmEngineerTests{

    @Test
    public void testByName(){
    // create new red black tree
        AEIPokeRBT rbt = new AEIPokeRBT();

        // create 5 new pokemon objects to insert into the tree
        AEPokemonForTests.Pokemon1 poke1 = new AEPokemonForTests.Pokemon1();
        AEPokemonForTests.Pokemon2 poke2 = new AEPokemonForTests.Pokemon2();
        AEPokemonForTests.Pokemon3 poke3 = new AEPokemonForTests.Pokemon3();
        AEPokemonForTests.Pokemon4 poke4 = new AEPokemonForTests.Pokemon4();
        AEPokemonForTests.Pokemon5 poke5 = new AEPokemonForTests.Pokemon5();

        //insert 5 pokemons into the tree
        rbt.insert(poke1);
        rbt.insert(poke2);
        rbt.insert(poke3);
        rbt.insert(poke4);
        rbt.insert(poke5);

        Iterator<IPokemon> poke= rbt.iterator(); // create iterator to iterate through the tree

        assertEquals(poke.next().getName(), "Bulbasaur");
        // check if the first pokemon in the tree is Bulbasaur
        assertEquals(poke.next().getName(), "Ivysaur");
        // check if the second pokemon in the tree is Ivysaur
        assertEquals(poke.next().getName(), "Pikachu");
        // check if the third pokemon in the tree is Pikachu
        assertEquals(poke.next().getName(), "Venusaur");
        // check if the fourth pokemon in the tree is Venusaur
        assertEquals(poke.next().getName(), "Meowth");
        // check if the fifth pokemon in the tree is Meowth
    }

    @Test
    public void testByID(){
        // create new red black tree
        AEIPokeRBT rbt = new AEIPokeRBT();

        // create 5 new pokemon object to insert into the tree
        AEPokemonForTests.Pokemon1 poke1 = new AEPokemonForTests.Pokemon1();
        AEPokemonForTests.Pokemon2 poke2 = new AEPokemonForTests.Pokemon2();
        AEPokemonForTests.Pokemon3 poke3 = new AEPokemonForTests.Pokemon3();
        AEPokemonForTests.Pokemon4 poke4 = new AEPokemonForTests.Pokemon4();
        AEPokemonForTests.Pokemon5 poke5 = new AEPokemonForTests.Pokemon5();

        //insert 5 pokemons into the tree
        rbt.insert(poke1);
        rbt.insert(poke2);
        rbt.insert(poke3);
        rbt.insert(poke4);
        rbt.insert(poke5);

        Iterator<IPokemon> poke= rbt.iterator(); // create iterator to iterate through the tree

        assertEquals(poke.next().getID(), "1");
        // check if the first pokemon in the tree has ID 1
        assertEquals(poke.next().getID(), "2");
        // check if the second pokemon in the tree has ID 2
        assertEquals(poke.next().getID(), "26");
        // check if the third pokemon in the tree has ID 26
        assertEquals(poke.next().getID(), "3");
        // check if the third pokemon in the tree has ID 3
        assertEquals(poke.next().getID(), "52");
        // check if the third pokemon in the tree has ID 52
    }

    @Test
    public void testByHP(){
        // create new red black tree
        AEIPokeRBT rbt = new AEIPokeRBT();

        // create 5 new pokemon objects to insert into the tree
        AEPokemonForTests.Pokemon1 poke1 = new AEPokemonForTests.Pokemon1();
        AEPokemonForTests.Pokemon2 poke2 = new AEPokemonForTests.Pokemon2();
        AEPokemonForTests.Pokemon3 poke3 = new AEPokemonForTests.Pokemon3();
        AEPokemonForTests.Pokemon4 poke4 = new AEPokemonForTests.Pokemon4();
        AEPokemonForTests.Pokemon5 poke5 = new AEPokemonForTests.Pokemon5();

        //insert 5 pokemons into the tree
        rbt.insert(poke1);
        rbt.insert(poke2);
        rbt.insert(poke3);
        rbt.insert(poke4);
        rbt.insert(poke5);

        Iterator<IPokemon> poke= rbt.iterator(); // create iterator to iterate through the tree

        assertEquals(poke.next().getHP(), "45");
        // check if the first pokemon in the tree has HP 45
        assertEquals(poke.next().getHP(), "60");
        // check if the second pokemon in the tree has HP 60
        assertEquals(poke.next().getHP(), "35");
        // check if the third pokemon in the tree has HP 35
        assertEquals(poke.next().getHP(), "80");
        // check if the fourth pokemon in the tree has HP 80
        assertEquals(poke.next().getHP(), "40");
        // check if the fifth pokemon in the tree has HP 40
    }

    @Test
    public void testByType(){
        // create new red black tree
        AEIPokeRBT rbt = new AEIPokeRBT();

        // create 5 new pokemon objects to insert into the tree
        AEPokemonForTests.Pokemon1 poke1 = new AEPokemonForTests.Pokemon1();
        AEPokemonForTests.Pokemon2 poke2 = new AEPokemonForTests.Pokemon2();
        AEPokemonForTests.Pokemon3 poke3 = new AEPokemonForTests.Pokemon3();
        AEPokemonForTests.Pokemon4 poke4 = new AEPokemonForTests.Pokemon4();
        AEPokemonForTests.Pokemon5 poke5 = new AEPokemonForTests.Pokemon5();

        //insert 5 pokemons into the tree
        rbt.insert(poke1);
        rbt.insert(poke2);
        rbt.insert(poke3);
        rbt.insert(poke4);
        rbt.insert(poke5);

        Iterator<IPokemon> poke= rbt.iterator(); // create iterator to iterate through the tree

        assertEquals(poke.next().getType(), "Seed Pokémon");
        // check if the first pokemon in the tree is a Seed Pokémon
        assertEquals(poke.next().getType(), "Seed Pokémon");
        // check if the second pokemon in the tree is a Seed Pokémon
        assertEquals(poke.next().getType(), "Mouse Pokémon");
        // check if the third pokemon in the tree is a Mouse Pokémon
        assertEquals(poke.next().getType(), "Seed Pokémon");
        // check if the fourth pokemon in the tree is a Seed Pokémon
        assertEquals(poke.next().getType(), "Scratch Cat Pokémon");
        // check if the fifth pokemon in the tree is a Scratch Cat Pokémon
    }

    @Test
    public void testCompareTo(){
        // create new red black tree
        AEIPokeRBT rbt = new AEIPokeRBT();
        // create 5 new pokemon objects to insert into the tree
        AEPokemonForTests.Pokemon1 poke1 = new AEPokemonForTests.Pokemon1();
        AEPokemonForTests.Pokemon2 poke2 = new AEPokemonForTests.Pokemon2();
        AEPokemonForTests.Pokemon3 poke3 = new AEPokemonForTests.Pokemon3();
        AEPokemonForTests.Pokemon4 poke4 = new AEPokemonForTests.Pokemon4();
        AEPokemonForTests.Pokemon5 poke5 = new AEPokemonForTests.Pokemon5();

        //insert 5 pokemons into the tree
        rbt.insert(poke1);
        rbt.insert(poke2);
        rbt.insert(poke3);
        rbt.insert(poke4);
        rbt.insert(poke5);

        Iterator<IPokemon> poke= rbt.iterator(); // create iterator to iterate through the tree

        assertEquals(poke.next().compareTo(poke1), 0);
        // check if the first pokemon in the tree is equal to poke1
        assertEquals(poke.next().compareTo(poke2), 0);
        // check if the second pokemon in the tree is equal to poke2
        assertEquals(poke.next().compareTo(poke3), 0);
        // check if the third pokemon in the tree is equal to poke3
        assertEquals(poke.next().compareTo(poke5), 0);
        // check if the fourth pokemon in the tree is equal to poke5
        assertEquals(poke.next().compareTo(poke4), 0);
        // check if the fifth pokemon in the tree is equal to poke4
    }

    @Test
    public void IntegrationTestByID(){
        // create new red black tree
        AEIPokeRBT rbt = new AEIPokeRBT();
        // create 5 new pokemon objects to insert into the tree
        AEPokemonForTests.Pokemon1 poke1 = new AEPokemonForTests.Pokemon1();
        AEPokemonForTests.Pokemon2 poke2 = new AEPokemonForTests.Pokemon2();
        AEPokemonForTests.Pokemon3 poke3 = new AEPokemonForTests.Pokemon3();

        //insert 5 pokemons into the tree
        rbt.insert(poke1);
        rbt.insert(poke2);
        rbt.insert(poke3);

        Iterator<IPokemon> poke= rbt.iterator();
        // create iterator to iterate through the tree

        assertEquals(poke.next().getID(), "1");
        // check if the first pokemon in the tree has ID 1
        assertEquals(poke.next().getID(), "2");
        // check if the second pokemon in the tree has ID 2
        assertEquals(poke.next().getID(), "26");
        // check if the third pokemon in the tree has ID 3
    }

    @Test
    public void IntegrationTestByName(){
        // create new red black tree
        AEIPokeRBT rbt = new AEIPokeRBT();
        // create 5 new pokemon objects to insert into the tree
        AEPokemonForTests.Pokemon1 poke1 = new AEPokemonForTests.Pokemon1();
        AEPokemonForTests.Pokemon2 poke2 = new AEPokemonForTests.Pokemon2();
        AEPokemonForTests.Pokemon3 poke3 = new AEPokemonForTests.Pokemon3();

        //insert 5 pokemons into the tree
        rbt.insert(poke1);
        rbt.insert(poke2);
        rbt.insert(poke3);

        Iterator<IPokemon> poke= rbt.iterator();
        // create iterator to iterate through the tree

        assertEquals(poke.next().getName(), "Bulbasaur");
        // check if the first pokemon in the tree has ID 1
        assertEquals(poke.next().getName(), "Ivysaur");
        // check if the second pokemon in the tree has ID 2
        assertEquals(poke.next().getName(), "Pikachu");
        // check if the third pokemon in the tree has ID 3
    }


    @Test
    public void IntegrationCodeReviewOfDataWranglerTestSize() throws FileNotFoundException {

        AEIPokeRBT rbt = new AEIPokeRBT();
        // create new red black tree
        PokeLoader pokemons = new PokeLoader();
        // create new PokeLoader object
        List listPokemon = pokemons.loadPokemon("pokemon.xml");
        // load the pokemon.xml file into a list

        assertEquals(listPokemon.size(), 801);
        // check if the size of the list is 801 (the number of pokemon in the file)
    }

    @Test
    public void IntegrationCodeReviewOfDataWranglerTestIsEmpty() throws FileNotFoundException {

        AEIPokeRBT rbt = new AEIPokeRBT();
        // create new red black tree
        PokeLoader pokemons = new PokeLoader();
        // create new PokeLoader object
        try { // try to load the pokemon.xml file
            List ankit1 = pokemons.loadPokemon("pokemn.xml");
            // load the pokemon.xml file into a list (this file does not exist)
        } catch (FileNotFoundException e) { // if the file does not exist
            assertTrue(rbt.isEmpty()); // check if the tree is empty (it should be)
        }
    }

}
