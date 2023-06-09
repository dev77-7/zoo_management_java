public class Panda extends Animal {
    public Panda(String name) {
        super(name);
    }

    @Override
    public void giveFood(int totalCost) {
        setHunger(getHunger() - 25);
        setThirst(getThirst() + 15);
        setBoredom(getBoredom() + 15);
        VirtualZoo.totalCost += 60;
        checkDeath();
    }

    @Override
    public void giveWater(int totalCost) {
        setHunger(getHunger() + 40);
        setThirst(getThirst() - 80);
        setBoredom(getBoredom() + 10);
        VirtualZoo.totalCost += 5;
        checkDeath();
    }

    @Override
    public void giveToy(int totalCost) {
        setHunger(getHunger() + 40);
        setThirst(getThirst() + 15);
        setBoredom(getBoredom() - 40);
        VirtualZoo.totalCost += 10;
        checkDeath();
    }
    public String getSpecies() {
        return "Panda";
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