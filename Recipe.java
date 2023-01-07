class Recipe {

    private Gobblegum input1; //The gobblegum required for input 1
    private int input1Qty; //The amount of the first gobblegum
    private Gobblegum input2; //The gobblegum required for input 2 (optional)
    private int input2Qty; //The amount of the second gobblegum
    private Gobblegum output; //The resulting gobblegum
    private int outQty; //The amount of the output
    private Boolean has2Input; //Flag to mark how many input

    /**
     * Constructs a recipe object with 1 input gum
     * @param qty - The quantity of the input gum required
     * @param in - The input gum required
     * @param out - The output gum given
     * @param outQty - The quantity of the output gum given
     */
    Recipe(int qty, Gobblegum in, Gobblegum out, int outQty) {
        this.input1Qty = qty;
        this.input1 = in;
        this.input2Qty = 0;
        this.input2 = null;
        this.output = out;
        this.outQty = outQty;
        this.has2Input = false;
    }

    /**
     * Constructs a recipe object with 1 input gum
     * @param qty1 - The quantity of the first input gum required
     * @param in1 - The first input gum required
     * @param qty2 - The quantity of the second input gum required
     * @param in2 - The second input gum required
     * @param out - The output gum given
     * @param outQty - The quantity of the output gum given
     */
    Recipe(int qty1, Gobblegum in1, int qty2, Gobblegum in2, Gobblegum out, int outQty) {
        this.input1Qty = qty1;
        this.input1 = in1;
        this.input2Qty = qty2;
        this.input2 = in2;
        this.output = out;
        this.outQty = outQty;
        this.has2Input = true;
    }

    /**
     * Returns whether the recipe has 2 inputs or not
     * @return - boolean flag 
     */
    public Boolean has2Input() {
        return this.has2Input;
    }

    /**
     * Gets the output of the recipe
     * @return The Gobblegum output of the recipe
     */
    public Gobblegum getOut() {
        return this.output;
    }

    /**
     * Returns the Gobblegum input of the recipe
     * @param index - Specifies which input to return
     * @return Recipe input Gobblegum
     */
    public Gobblegum getIn(int index) {
        if (index == 1) {
            return input1;
        } else if (index == 2) {
            return input2;
        } else {
            return null;
        }
    }

    /**
     * Returns the Gobblegum input qty of the recipe
     * @param index - Specifies which input to return
     * @return Recipe input Gobblegum qty as an int
     */
    public int getInQty(int index) {
        if (index == 1) {
            return input1Qty;
        } else if (index == 2) {
            return input2Qty;
        } else {
            return -1;
        }
    }

    /**
     * Returns quantity of the output in the recipe
     * @return The quantity of the output as an int
     */
    public int getOutQty() {
        return this.outQty;
    }

    /**
     * Returns a string of the recipe
     */
    public String toString() {
        return input1Qty + " " + input1 + " = " + outQty + " " + output;
    }

}