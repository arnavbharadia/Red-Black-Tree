// --== CS400 Fall 2022 File Header Information ==--
// Name: Aidan Mulvaney
// Email: amulvaney@wisc.edu
// Team: CC Red
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: n/a

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements some methods so that the frontend can interface with
 * the algorithm engineers internal RBT
 */
public class PokeBackend implements IPokeBackend {
    protected IPokeRBT rbt;
    protected IPokeValidator validator;

    protected String typeFilter = null;

    /**
     * Constructor for the backend
     */
    public PokeBackend() {
        rbt = new AEIPokeRBT();
        validator = new AEIPokeValidator();
    }

    /**
     * constructor for the backend, uses placeholders for testing
     * @param rbt the placeholder RBT
     */
    public PokeBackend(IPokeRBT rbt) {
        this.rbt = rbt;
        validator = (id) -> { return (id == 69 || id == 621); };
    }

    /**
     * adds a Pokemon to the internal RBT
     * @param pokemon the Pokemon to add
     */
    @Override
    public void addPokemon(IPokemon pokemon) {
        if (validator.isValidPokedexID(Integer.parseInt(pokemon.getID()))) {
            rbt.insert(pokemon);
        }
    }

    /**
     * gets the number of Pokemon in the internal RBT
     * @return the number of Pokemon in the internal RBT
     */
    @Override
    public int getNumberPokemon() {
        int count = 0;
        for (IPokemon p : rbt) {
            count++;
        }
        return count;
    }

    /**
     * set the type filter for which to filter Pokemon
     * @param typeFilter the type filter to set, set to null for no filter
     */
    @Override
    public void setTypeFilter(String typeFilter) {
        this.typeFilter = typeFilter;
    }

    /**
     * gets the current type filter
     * @return the current type filter, null if no filter is set
     */
    @Override
    public String getTypeFilter() {
        return typeFilter;
    }

    /**
     * reset the type filter back to null, aka no filter
     */
    @Override
    public void resetTypeFilter() {
        typeFilter = null;
    }

    /**
     * searches through the internal RBT for Pokemon with a specific name,
     * and with a corresponding type if typeFilter is set
     * @param name the name of the Pokemon to search for
     * @return a list of Pokemon with the name and type corresponding to typeFilter
     */
    @Override
    public List<IPokemon> searchByName(String name) {
        List<IPokemon> list = new ArrayList<>();
        for (IPokemon p : rbt) {
            if (typeFilter == null || p.getType().equals(typeFilter)) {
                if (p.getName().contains(name)) {
                    list.add(p);
                }
            }
        }
        
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * Searches through the internal RBT to find Pokemon with the corresponding hp
     * and the typeFilter if it is set
     * @param hp the hp of the Pokemon to search for
     * @return a list of Pokemon with the corresponding hp and typeFilter if it is set
     */
    @Override
    public List<IPokemon> seachByHP(int hp) {
        ArrayList<IPokemon> list = new ArrayList<>();
        for (IPokemon p : rbt) {
            if (typeFilter == null || p.getType().equals(typeFilter)) {
                if (p.getHP().equals(Integer.toString(hp))) {
                    list.add(p);
                }
            }
        }

        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * Returns a Pokemon if the id corresponding to it is valid
     * @param id the id of the pokemon to look for
     * @return the Pokemon corresponding to the id, null if the id is invalid
     */
    @Override
    public IPokemon getByID(int id) {
        try {
            validator.isValidPokedexID(id);
            for (IPokemon p : rbt) {
                if (p.getID().equals(Integer.toString(id))) {
                    return p;
                }
            }
        } catch (Exception e) {
            // if the validator could not validate the id, it throws an exception
            return null;
        }
        // default return if id is invalid or the pokemon 
        // associated with that ID is not in the database
        return null;
    }
}