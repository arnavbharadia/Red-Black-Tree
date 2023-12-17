// --== CS400 Fall 2022 File Header Information ==--
// Name: Aidan Mulvaney
// Email: amulvaney@wisc.edu
// Team: CC Red
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: n/a

import java.util.ArrayList;
import java.util.Iterator;

public class BackendPlaceholderPokeRBT implements IPokeRBT {
    private ArrayList<IPokemon> pokeList = new ArrayList<>();

    IPokemon poke1 = new IPokemon() {
        public String getName() { return "Druddigon"; }
        public String getHP() { return "77"; }
        public String getType() { return "dragon"; }
        public String getID() { return "621"; }
        public int compareTo(IPokemon p) { return 1; } // greater than poke2
    };

    IPokemon poke2 = new IPokemon() {
        public String getName() { return "Bellsprout"; }
        public String getHP() { return "50"; }
        public String getType() { return "grass"; }
        public String getID() { return "69"; }
        public int compareTo(IPokemon p) { return -1; } // less than poke1
    };

    public boolean insert(IPokemon p) {
        return pokeList.add(p);
    }

    /**
     * Iterate through the two placeholder pokemon
     * 
     * @return an Iterator
     */
    public Iterator<IPokemon> iterator() {
        return pokeList.iterator();
    }

    // below methods are unused for placeholder

    @Override
    public boolean contains(IPokemon data) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}