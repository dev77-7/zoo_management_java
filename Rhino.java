public class Rhino extends Animal {
    public Rhino(String name) {
        super(name);
    }

    @Override
    public void giveFood(int totalCost) {
        setHunger(getHunger() - 25);
        setThirst(getThirst() + 5);
        setBoredom(getBoredom() + 25);
        VirtualZoo.totalCost += 50;
        checkDeath();
    }

    @Override
    public void giveWater(int totalCost) {
        setHunger(getHunger() + 5);
        setThirst(getThirst() - 25);
        setBoredom(getBoredom() + 25);
        VirtualZoo.totalCost += 50;
        checkDeath();
    }

    @Override
    public void giveToy(int totalCost) {
        setHunger(getHunger() + 20);
        setThirst(getThirst() + 20);
        setBoredom(getBoredom() - 50);
        VirtualZoo.totalCost += 20;
        checkDeath();
    }

    public String getSpecies() {
        return "Rhino";
    }

    private void setHunger(int value) {
        super.hunger = value;
    }

    private void setThirst(int value) {
        super.thirst = value;
    }

    private void setBoredom(int value) {
        super.boredom = value;
    }
}
