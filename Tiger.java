public class Tiger extends Animal {
    public Tiger(String name) {
        super(name);
    }

    @Override
    public void giveFood(int totalCost) {
        setHunger(getHunger() - 30);
        setThirst(getThirst() + 15);
        setBoredom(getBoredom() + 15);
        VirtualZoo.totalCost += 30;
        checkDeath();
    }

    @Override
    public void giveWater(int totalCost) {
        setHunger(getHunger() + 15);
        setThirst(getThirst() - 30);
        setBoredom(getBoredom() + 15);
        VirtualZoo.totalCost += 20;
        checkDeath();
    }

    @Override
    public void giveToy(int totalCost) {
        setHunger(getHunger() + 15);
        setThirst(getThirst() + 15);
        setBoredom(getBoredom() - 30);
        VirtualZoo.totalCost += 40;
        checkDeath();
    }
    public String getSpecies() {
        return "Tiger";
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