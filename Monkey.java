public class Monkey extends Animal {
    public Monkey(String name) {
        super(name);
    }

    @Override
    public void giveFood(int totalCost) {
        setHunger(getHunger() - 30);
        setThirst(getThirst() + 10);
        setBoredom(getBoredom() + 10);
        VirtualZoo.totalCost += 5;
        checkDeath();
    }

    @Override
    public void giveWater(int totalCost) {
        setHunger(getHunger() + 10);
        setThirst(getThirst() - 40);
        setBoredom(getBoredom() + 10);
        VirtualZoo.totalCost += 5;
        checkDeath();
    }

    @Override
    public void giveToy(int totalCost) {
        setHunger(getHunger() + 10);
        setThirst(getThirst() + 10);
        setBoredom(getBoredom() - 15);
        VirtualZoo.totalCost += 15;
        checkDeath();
    }
    public String getSpecies() {
        return "Monkey";
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