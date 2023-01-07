import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cycle {

    private Offering[] offerings = new Offering[36]; //Container for offerings
    private int cycleIndex; //Current day in the cycle

    /**
     * Creates cycle by reading in the cycle text file, splitting each string up and
     * using the data to create 3 recipes to finally create an offering and place it 
     * in the offerings container.
     * @param g - The GumMaster object
     * @throws FileNotFoundException
     */
    private void createCycle(GumMaster g) throws FileNotFoundException {
        File file = new File("cycle.txt");
        Scanner sc = new Scanner(file);
    
        int index = 0;

        while (index < 36) {
            Recipe[] recipeArr = new Recipe[3];

            //Create 3 recipes for every day and add them into the recipe array
            for(int i = 0; i < 3; i++) {
                String line = sc.nextLine();
                String[] arr = line.split(",", 7);
                cycleIndex = Integer.parseInt(arr[6]);

                if (arr[3] != "") {
                    recipeArr[i] = new Recipe(Integer.parseInt(arr[0]), g.getGum(arr[1]), Integer.parseInt(arr[2]), g.getGum(arr[3]), g.getGum(arr[5]), Integer.parseInt(arr[4]));
                } else {
                    recipeArr[i] = new Recipe(Integer.parseInt(arr[0]), g.getGum(arr[1]), g.getGum(arr[5]), Integer.parseInt(arr[4]));
                }
            }

            //Add offering to offerings array
            offerings[index] = new Offering(index+1, recipeArr[0], recipeArr[1], recipeArr[2]);
            index++;
        }
        sc.close();
    }

    /**
     * Constructs a cycle object
     * @param g - The GumMaster object
     */
    Cycle(GumMaster g) {
        try {
            createCycle(g);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Finds the current day of the cycle based on the offered gums
     * @param g1 - The first offered Gobblegum
     * @param g2 - The second offered Gobblegum
     * @param g3 - THe third offered Gobblegum
     * @return cycle index as an integer
     */
    public int findCycleIndex(Gobblegum g1, Gobblegum g2, Gobblegum g3) {
       
        //Search through cycle
        for (int i = 0; i < 36; i++) {

            if (g1 == offerings[i].getOffering(0)) {

                if (g2 == offerings[i].getOffering(1)) {

                    if (g3 == offerings[i].getOffering(2)) {
                        this.cycleIndex = i;
                        return i;
                    }
                }
            }
        }
        return -1; 
    }

    /**
     * Returns cycle index
     * @return cycle index as an integer
     */
    public int getCycleIndex() {
        return this.cycleIndex;
    }
    
    /**
     * Sets index of cycle 
     * @param index - The index to set the cycle to
     */
    public void setCycleIndex(int index) {
        this.cycleIndex = index;
    }

    /**
     * Returns the current daily offering
     * @return the current daily offering of gums
     */
    public Offering getCurrentOffering() {
        return offerings[cycleIndex];
    }

    /**
     * Returns offering at specified index
     * @param index - The specific Offering to return
     * @return An Offering object with the corresponding index
     */
    public Offering getOffering(int index) {
        return offerings[index];
    }

    /**
     * Returns a queue of all the primary trades in the cycle according to current gums obtained
     * @param desiredGumArr - An array of desired Gobblegum
     * @return A queue containing all the primary trades in the cycle for the desired gum
     */
    public Queue<Offering> getDesiredQueue(Gobblegum[] desiredGumArr) {

        Queue<Offering> desiredQueue = new LinkedList<Offering>();

        //Step through all offerings
        for (Offering o : offerings) {

            //If offering is already in queue, continue
            if (desiredQueue.contains(o)) {
                continue;
            }

            //Check each gum in the desired gum array
            for (int i = 0; i < desiredGumArr.length; i++) {

                //Break out of loop if desired is null
                //TODO:: Refactor this
                if (desiredGumArr[i] == null) {
                    break;
                }

                //Check if desired gum is in offering
                int index = o.getOfferingIndex(desiredGumArr[i].getName());
                
                //If not in offering, continue
                if (index == -1) {
                    continue;
                }

                desiredQueue.add(o);
            }
        }
        return desiredQueue;
    }

    /**
     * Finds all offerings containing a given gum
     * @param g - The Gobblegum to search offerings for
     * @return A Queue of all the offerings
     */
    public Queue<Offering> findAllOfferings(Gobblegum g) {
        Queue<Offering> futureQ = new LinkedList<Offering>();

        for (int i = 0; i < 36; i++) {
            if (g == offerings[i].getOffering(0) || g == offerings[i].getOffering(1) || g == offerings[i].getOffering(2)) {
                futureQ.add(offerings[i]);
            }
        }

        return futureQ;
    }

    /**
     * Returns a string containing the entire cycle of the Newton's Cookbook
     */
    public String toString() {
        String out = "";

        for (int i = 0; i < 36; i++) {
            out += offerings[i] + "\n";
        }

        return out;
    }

}