abstract class Fighter {

    public String toString() {
        return "Fighter is a ";
    }

    boolean isVulnerable() {
        throw new UnsupportedOperationException("Please provide implementation for this method");
    }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends Fighter {

    @Override
    public String toString() {
        return super.toString() + "Warrior";
    }

    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int damagePoints(Fighter fighter) {
        return (fighter.isVulnerable()) ? 10 : 6;
    }
}

class Wizard extends Fighter {
    private boolean isSpellPrepared = false;

    @Override
    public String toString() {
        return super.toString() + "Wizard";
    }

    @Override
    boolean isVulnerable() {
        return !this.isSpellPrepared;
    }

    @Override
    int damagePoints(Fighter warrior) {
        return (this.isSpellPrepared) ? 12 : 3;
    }

    void prepareSpell() {
        this.isSpellPrepared = true;
    }

}
