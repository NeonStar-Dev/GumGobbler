import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Inventory {

    private Gobblegum[] gumList = new Gobblegum[44]; //Container for all 44 gobblegums
    private Gobblegum[] desiredGums = new Gobblegum[10]; //Container for 10 desired gobblegums
    private int desiredSize = 0; //The size of the desired container
    private Queue<Offering> desiredOfferings = new LinkedList<Offering>(); //Container for the desired gums offerings

    /**
     * Add saved amounts to the totals of the Gobblegums in the inventory from the amounts text file
     * @throws FileNotFoundException
     */
    private void addAmounts() throws FileNotFoundException {

        File file = new File("amounts.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter(",");
        int index = 0;

        while (index < 44) {
            gumList[index].addGum(sc.nextInt());
            index++;
        }
        sc.close();
    }

    /**
     * Populates the inventory gum list
     * @param gumArr - A copy of the Gobblegum master list
     */
    private void fillGums(Gobblegum[] gumArr) {
        gumList = gumArr;
    }

    /**
     * Constructs an Inventory object, populating the list and adding saved amounts
     * @param g - The GumMaster object
     */
    Inventory(GumMaster g) {
        fillGums(g.copyList());
        try {
            addAmounts();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Adds a Gobblegum to the desired container
     * @param g - The Gobblegum to add to the desired container
     * @throws Exception - If 10 gobblegums are already in the desired container
     */
    public void addDesired(Gobblegum g) {
        this.desiredGums[desiredSize] = g;
        g.setDesired();
        this.desiredSize++;
    }

    /**
     * Adds the desired queue to the inventory
     * @param desired - a copy of the desired queue
     */
    public void addDesiredQueue(Queue<Offering> desired) {
        this.desiredOfferings = desired;
    }

    /**
     * Returns a list of all trades for desired gum
     * TODO:: Add secondary trades
     * TODO:: Save recipe to make function calls shorter and more readable
     * @return A string list of all trades
     */
    public String desiredTradesToString() {
        String out = "";
        
            //Cycle through each offering
            for (Offering o : desiredOfferings) {

                //Cycle through each desired gum
                for (int i = 0; i < this.desiredSize; i++) {
                    int index = o.getOfferingIndex(desiredGums[i].getName());
                    
                    //If gum not in offering, continue
                    if (index == -1) {
                        continue;
                    }
                    
                    out += "Day " + o.getCycleIndex() + " - " + o.getOffering(index).getName();
                    out += "\n\t" + this.getQty(o.getRecipe(index).getIn(1).getName()) + "/"; 
                    out += o.getRecipe(index).getInQty(1) + " " + o.getRecipe(index).getIn(1).getName();

                    //If there are 2 inputs, add second
                    if (o.getRecipe(index).has2Input()) {
                        out += " + " + this.getQty(o.getRecipe(index).getIn(2).getName()) + "/";
                        out += o.getRecipe(index).getInQty(2) + " " + o.getRecipe(index).getIn(2).getName();
                    }

                    out += " = (+"; 

                    int in1Result = (int)Math.floor((this.getQty(o.getRecipe(index).getIn(1).getName())))/(o.getRecipe(index).getInQty(1));
                    
                    //If recipe has 2 inputs, calculate the amount of the desired gum from both
                    if (o.getRecipe(index).has2Input()) {
                        int in2Result = (int)Math.floor((this.getQty(o.getRecipe(index).getIn(2).getName())))/(o.getRecipe(index).getInQty(2));
                        int min = Math.min(in1Result, in2Result);

                        out += min * o.getRecipe(index).getOutQty();

                    //Else use one input
                    } else {
                        out +=  in1Result * o.getRecipe(index).getOutQty(); 
                    }
                    
                    
                    out += ")" + o.getRecipe(index).getOut().getName() + "\n";
                }
            }
        
        

        return out;
    }

    /**
     * Returns quantity of specified gum in inventory
     * @param name - The name of the gum to get the quantity of
     * @return The quantity of the specified gum as an int
     */
    public int getQty(String name) {
        
        for (Gobblegum g : gumList) {

            if (name.toUpperCase().equals(g.getName())) {
                return g.getQty();
            }
        }
        return 0;
    }

    /**
     * Returns list of desired gums
     * @return array containing desired gum
     */
    public Gobblegum[] getDesiredGum() {
        return this.desiredGums;
    }

    /**
     * Returns a string object of the Inventory
     */
    public String toString() {
        String out = "";

        for (int i = 0; i < 44; i++) {
            out += gumList[i] + "\n";
        }

        return out;
    }

}