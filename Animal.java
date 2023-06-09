public abstract class Animal {
    public String name;
    public int hunger;
    public int thirst;
    public int boredom;
    private String previousItem;


    public Animal(String name) {
        this.name = name;
        this.hunger = 50;
        this.thirst = 50;
        this.boredom = 50;
    }

    public String getName() {
        return name;
    }


    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public boolean isDead() {
        return hunger >= 100 || thirst >= 100 || boredom >= 100;
    }
    public String getPreviousItem() {
        return previousItem;
    }

    public void setPreviousItem(String previousItem) {
        this.previousItem = previousItem;
    }

    public abstract void giveFood(int totalCost);

    public abstract void giveWater(int totalCost);

    public abstract void giveToy(int totalCost);

    public abstract String getSpecies();
    public void checkDeath() {
        if (isDead()) {
            VirtualZoo.totalCost += 1000;
            System.out.println(name + " has died");
        }
    }

    @Override
    public String toString() {
        String statusMessage = isDead() ? "Name = " + getName() + " (Dead)\n" : "Name = " + getName() + "\n";
        statusMessage += "Species = " + getSpecies() + "\n";
        statusMessage += "Hunger = " + getHunger() + "\n";
        statusMessage += "Thirst = " + getThirst() + "\n";
        statusMessage += "Boredom = " + getBoredom() + "\n";
        return statusMessage;
    }
}

