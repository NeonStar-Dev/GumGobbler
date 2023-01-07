class Gobblegum {
    
    private String name; //The name of the gobblegum
    private String description; //Description of the gobblegum
    private int qty; //The quantity of the gum (for inventory use)
    private Boolean desired; //whether the gum is desired or not

    /**
     * Constructs a Gobblegum object
     * @param name - The name of the Gobblegum
     * @param description - A description of what the Gobblegum does
     */
    Gobblegum(String name, String description) { 
        this.name = name;
        this.description = description;
        this.qty = 0;
        this.desired = false;
    }

    /**
     * Constructs a copy of a Gobblegum
     * @param g - The Gobblegum to be copied
     */
    Gobblegum(Gobblegum g) {
        this.name = g.name;
        this.description = g.description;
    }

    /**
     * Returns the name of the Gobblegum object
     * @return - The name of the Gobblegum object
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns quantity of gum
     * @return int containing quantity of gum
     */
    public int getQty() {
        return this.qty;        
    }

    /**
     * Sets the desired variable to true
     */
    public void setDesired() {
        this.desired = true;
    }

    /**
     * Returns whether gum is desired or not
     * @return a boolean flag
     */
    public Boolean isDesired() {
        return this.desired;
    }

    /**
     * Adds a specified amount to the Gobblegum total
     * @param add - The amount to add to the Gobblegum
     */
    public void addGum(int add) {
        qty += add;
    }

    /**
     * Returns a string of the Gobblegum object
     */
    public String toString() {
        return "(" + this.qty + ")" + this.name + " - " + this.description;
    }

}