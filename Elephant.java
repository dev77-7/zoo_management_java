public class Elephant extends Animal {
    public Elephant(String name) {
        super(name);
    }

    @Override
    public void giveFood(int totalCost) {
        setHunger(getHunger() - 50);
        setThirst(getThirst() + 30);
        setBoredom(getBoredom() + 20);
        VirtualZoo.totalCost += 100;
        checkDeath();
    }

    @Override
    public void giveWater(int totalCost) {
        setHunger(getHunger() + 20);
        setThirst(getThirst() - 50);
        setBoredom(getBoredom() + 30);
        VirtualZoo.totalCost += 40;
        checkDeath();
    }

    @Override
    public void giveToy(int totalCost) {
        setHunger(getHunger() + 30);
        setThirst(getThirst() + 10);
        setBoredom(getBoredom() - 40);
        VirtualZoo.totalCost += 75;
        checkDeath();
    }
    public String getSpecies() {
        return "Elephant";
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