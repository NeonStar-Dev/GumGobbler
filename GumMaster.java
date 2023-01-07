import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class GumMaster {

    private Gobblegum[] gumList = new Gobblegum[44]; //Container for all 44 gobblegums

    /**
     * Creates master list for gums from text file
     * @throws FileNotFoundException
     */
    private void createList() throws FileNotFoundException {

        // pass the path to the file as a parameter
        File file = new File("gobblegum.txt");
        Scanner sc = new Scanner(file);
        int index = 0;

        while (index < 44) {
            String line = sc.nextLine();
            String[] arr = line.split("//", 2);
            gumList[index] = new Gobblegum(arr[0], arr[1]);
            index++;
        }
        sc.close();
    }

    /**
     * Constructor creates a GumMaster object and populates its master list
     */
    GumMaster() {
        try {
            createList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the gobblegum searched for by name
     * @param gumName - The name of the gum being searched
     * @return The gobblegum
     */
    public Gobblegum getGum(String gumName) {
        for (int i = 0; i < 44; i++) {
            if (gumName.equals(gumList[i].getName())) {
                return gumList[i];
            } 
        }

        return null;
    }

    /**
     * Copies the master gum list and returns it for populating other gum lists
     * @return a copy of the master gum list
     */
    public Gobblegum[] copyList() {
        Gobblegum[] copy = new Gobblegum[44];

        for (int i = 0; i < 44; i++) {
            copy[i] = new Gobblegum(gumList[i]);
        }

        return copy;
    }
}