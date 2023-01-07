class Driver {
    public static void main(String[] args) {
        
        //Startup
        GumMaster g = new GumMaster(); //Create Gum Master List
        Inventory in = new Inventory(g); //Create Inventory
        Cycle cy = new Cycle(g); //Create Cycle 

        //Cycle resets at 7pm daily
        //cy.findCycleIndex(g.getGum(""), g.getGum(""), g.getGum(""));
        cy.setCycleIndex(19);
        System.out.println("TODAY - " + cy.getCurrentOffering()); //Print current offering

        in.addDesired(g.getGum("PERKAHOLIC")); //Add desired gum
        in.addDesired(g.getGum("NEAR DEATH EXPERIENCE")); //Add desired gum
        in.addDesired(g.getGum("SHOPPING FREE")); //Add desired gum
        
        in.addDesiredQueue(cy.getDesiredQueue(in.getDesiredGum())); //Create Desired Queue
        System.out.println(in.desiredTradesToString()); //Print desired trades
    }
}