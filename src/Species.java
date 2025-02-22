public enum Species {
    CAT(false, 4, true),
    DOG(false, 4, true),
    HORSE(false, 4, true),
    SHEEP(false, 4, true),
    COW(false, 4, true),
    SNAKE(false, 0, false),
    FOX(false, 4, true),
    CAPYBARA(false, 4, true),
    FISH(false, 0, false),
    OWL(true, 2, false),
    PARROT(true, 2, false),
    HAMSTER(false, 4, true),
    TARANTULA(false, 8, false),
    ANONYMOUS(false, 0, false);

    private boolean canFly;
    private int numberOfLegs;
    private boolean hasFur;

    Species(boolean canFly, int numberOfLegs, boolean hasFur) {
        this.canFly = canFly;
        this.numberOfLegs = numberOfLegs;
        this.hasFur = hasFur;
    }

    // Getters
    public boolean getCanFly() {
        return canFly;
    }
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
    public boolean hasFur() {
        return hasFur;
    }
}
