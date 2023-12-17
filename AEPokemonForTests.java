// --== CS400 Fall 2022 File Header Information ==--
// Name: Arnav Bharadia
// Email: abharadia@wisc.edu
// Team: CC
// TA: Daniel
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

public class AEPokemonForTests {

    /**
     * This class represents a Pokemon and its associated data.
     */

    public static class Pokemon1 implements IPokemon {
        /**
         * Returns the name of the Pokemon.
         *
         * @return name of the Pokemon
         */
        @Override public String getName() {
            return "Bulbasaur";
        }

        /**
         * Returns the HP of this pokemon as an int
         *
         * @return int that is the HP
         */
        @Override public String getHP() {
            return "45";
        }

        /**
         * Returns the primary type of this Pokemon in a string
         *
         * @return the primary type of this Pokemon
         */
        @Override public String getType() {
            return "Seed Pokémon";
        }

        /**
         * Returns the Pokemon ID number that uniquely identifies this Pokemon.
         *
         * @return Pokemon ID number as an int
         */
        @Override public String getID() {
            return "1";
        }

        /**
         * Compares this Pokemon to the given Pokemon by ID number.
         * @param pokemon1 the object to be compared.
         * @return a negative integer, zero, or a positive integer as this Pokemon is less than,
         */
        @Override public int compareTo(IPokemon pokemon1) {
            return this.getID().compareTo(pokemon1.getID());
        }
    }
    public static class Pokemon2 implements IPokemon {
        /**
         * Returns the name of the Pokemon.
         *
         * @return name of the Pokemon
         */
        @Override public String getName() {
            return "Ivysaur";
        }

        /**
         * Returns the HP of this pokemon as an int
         *
         * @return int that is the HP
         */
        @Override public String getHP() {
            return "60";
        }

        /**
         * Returns the primary type of this Pokemon in a string
         *
         * @return the primary type of this Pokemon
         */
        @Override public String getType() {
            return "Seed Pokémon";
        }

        /**
         * Returns the Pokemon ID number that uniquely identifies this Pokemon.
         *
         * @return Pokemon ID number as an int
         */
        @Override public String getID() {
            return "2";
        }

        /**
         * Compares this Pokemon to the given Pokemon by ID number.
         * @param pokemon2 the object to be compared.
         * @return a negative integer, zero, or a positive integer as this Pokemon is less than,
         */
        @Override public int compareTo(IPokemon pokemon2) {
            return this.getID().compareTo(pokemon2.getID());
        }
    }

    public static class Pokemon3 implements IPokemon {
        /**
         * Returns the name of the Pokemon.
         *
         * @return name of the Pokemon
         */
        @Override public String getName() {
            return "Pikachu";
        }

        /**
         * Returns the HP of this pokemon as an int
         *
         * @return int that is the HP
         */
        @Override public String getHP() {
            return "35";
        }

        /**
         * Returns the primary type of this Pokemon in a string
         *
         * @return the primary type of this Pokemon
         */
        @Override public String getType() {
            return "Mouse Pokémon";
        }

        /**
         * Returns the Pokemon ID number that uniquely identifies this Pokemon.
         *
         * @return Pokemon ID number as an int
         */
        @Override public String getID() {
            return "26";
        }

        /**
         * Compares this Pokemon to the given Pokemon by ID number.
         * @param pokemon1 the object to be compared.
         * @return a negative integer, zero, or a positive integer as this Pokemon is less than,
         */
        @Override public int compareTo(IPokemon pokemon1) {
            return this.getID().compareTo(pokemon1.getID());
        }
    }

    public static class Pokemon4 implements IPokemon {
        /**
         * Returns the name of the Pokemon.
         *
         * @return name of the Pokemon
         */
        @Override public String getName() {
            return "Meowth";
        }

        /**
         * Returns the HP of this pokemon as an int
         *
         * @return int that is the HP
         */
        @Override public String getHP() {
            return "40";
        }

        /**
         * Returns the primary type of this Pokemon in a string
         *
         * @return the primary type of this Pokemon
         */
        @Override public String getType() {
            return "Scratch Cat Pokémon";
        }

        /**
         * Returns the Pokemon ID number that uniquely identifies this Pokemon.
         *
         * @return Pokemon ID number as an int
         */
        @Override public String getID() {
            return "52";
        }

        /**
         * Compares this Pokemon to the given Pokemon by ID number.
         * @param pokemon1 the object to be compared.
         * @return a negative integer, zero, or a positive integer as this Pokemon is less than,
         */
        @Override public int compareTo(IPokemon pokemon1) {
            return this.getID().compareTo(pokemon1.getID());
        }
    }

    public static class Pokemon5 implements IPokemon {
        /**
         * Returns the name of the Pokemon.
         *
         * @return name of the Pokemon
         */
        @Override public String getName() {
            return "Venusaur";
        }

        /**
         * Returns the HP of this pokemon as an int
         *
         * @return int that is the HP
         */
        @Override public String getHP() {
            return "80";
        }

        /**
         * Returns the primary type of this Pokemon in a string
         *
         * @return the primary type of this Pokemon
         */
        @Override public String getType() {
            return "Seed Pokémon";
        }

        /**
         * Returns the Pokemon ID number that uniquely identifies this Pokemon.
         *
         * @return Pokemon ID number as an int
         */
        @Override public String getID() {
            return "3";
        }

        /**
         * Compares this Pokemon to the given Pokemon by ID number.
         * @param pokemon1 the object to be compared.
         * @return a negative integer, zero, or a positive integer as this Pokemon is less than,
         * equal to, or greater than the specified object.
         */
        @Override public int compareTo(IPokemon pokemon1) {
            return this.getID().compareTo(pokemon1.getID());
        }
    }

}
