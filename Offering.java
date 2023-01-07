class Offering {

    private Gobblegum[] dailyOffering = new Gobblegum[3]; //container for the daily offering
    private Recipe[] offeringRecipes = new Recipe[3];
    private int cycleIndex; //index of the newton's cookbook cycle

    //private Recipe recipe1; //first gum recipe
    //private Recipe recipe2; //second gum recipe
    //private Recipe recipe3; //third gum recipe

    /**
     * Constructs an offering object
     * @param index - The day the offering appears in the cycle
     * @param r1 - The first recipe of the offering
     * @param r2 - The second recipe of the offering
     * @param r3 - The third recipe of the offering
     */
    Offering(int index, Recipe r1, Recipe r2, Recipe r3) {
        //Populate offering container
        this.dailyOffering[0] = r1.getOut();
        this.dailyOffering[1] = r2.getOut();
        this.dailyOffering[2] = r3.getOut();

        //Add index
        this.cycleIndex = index;

        //Add recipes
        this.offeringRecipes[0] = r1;
        this.offeringRecipes[1] = r2;
        this.offeringRecipes[2] = r3;
    }

    /**
     * Returns index of specified gum in the offering
     * @param name - The name of the gum to search the offering for
     * @return index of the gum as an int
     */
    public int getOfferingIndex(String name) {
        if (name.equals(dailyOffering[0].getName())) {
            return 0;

        } else if (name.equals(dailyOffering[1].getName())) {
            return 1;

        } else if (name.equals(dailyOffering[2].getName())) {
            return 2;

        } else {
            return -1;
        }
    }

    /**
     * Returns the specified Gobblegum
     * @param index - The index of the desired Gobblegum
     * @return Specified Gobblegum
     */
    public Gobblegum getOffering(int index) {
        return dailyOffering[index];
    }

    /**
     * Returns the specified Gobblegum
     * @param name - The name of the desired Gobblegum
     * @param index - A variable to hold the index of the returned gum
     * @return Specified Gobblegum
     */
    public Gobblegum getOffering(String name) {
        if (name.toUpperCase().equals(dailyOffering[0].getName())) {
            return dailyOffering[0];

        } else if (name.toUpperCase().equals(dailyOffering[1].getName())) {
            return dailyOffering[1];

        } else if (name.toUpperCase().equals(dailyOffering[2].getName())) {
            return dailyOffering[2];

        } else {
            return null;
        }
    }

    /**
     * Returns recipe based on index
     * @param index - The index of the desired recipe
     * @return The recipe specified by the index
     */
    public Recipe getRecipe(int index) {
        return offeringRecipes[index];
    }

    /**
     * Returns the cycle index
     * @return an int containing the cycle index
     */
    public int getCycleIndex() {
        return this.cycleIndex;
    }

    /**
     * Returns a string of the offering object 
     */
    public String toString() {
        return "Day " + this.cycleIndex + ": " + dailyOffering[0].getName() + ", " + dailyOffering[1].getName() + ", " + dailyOffering[2].getName();
    }
}