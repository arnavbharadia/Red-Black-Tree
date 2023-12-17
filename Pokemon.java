public class Pokemon implements IPokemon {
    private final String name;
    private final String HP;
    private final String type;
    private final String ID;

    public Pokemon(String name, String HP, String type, String ID) {
        this.name = name;
        this.HP = HP;
        this.type = type;
        this.ID = ID;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getHP() {
        return this.HP;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public int compareTo(IPokemon other) {
        if (other == null || this == null) {
            throw new NullPointerException();
        }
        int otherID = Integer.parseInt(other.getID());
        int thisID = Integer.parseInt(this.getID());
        if (thisID == otherID) {
            return 0;
        }
        if (thisID < otherID) {
            return -1;
        }
        if (thisID > otherID) {
            return 1;
        }
        return thisID;
    }

}
