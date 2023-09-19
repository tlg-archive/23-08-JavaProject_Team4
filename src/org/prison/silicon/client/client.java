package org.prison.silicon.client;

import org.prison.silicon.Facility;
import org.prison.silicon.FacilityList;
import org.prison.silicon.Prison;
import org.prison.silicon.SecurityRating;
import org.prison.silicon.gui.MainGui;
import org.prison.silicon.population.Inmate;
import org.prison.silicon.population.InmateLoader;

import java.io.IOException;
import java.util.List;

// TODO: Look at adding controller to a .app package to control game like in DuckRace
public class client {
    public static Facility lowSecurityUnit = new Facility(FacilityList.LOW_SECURITY_UNIT, 15, SecurityRating.LOW);
    public static Facility mediumSecurityUnit = new Facility(FacilityList.MEDIUM_SECURITY_UNIT, 15, SecurityRating.MEDIUM);
    public static Facility highSecurityUnit = new Facility(FacilityList.HIGH_SECURITY_UNIT, 15, SecurityRating.HIGH);
    public static Facility yard = new Facility(FacilityList.YARD, 75, SecurityRating.MEDIUM);
    public static Facility kitchen = new Facility(FacilityList.KITCHEN, 75, SecurityRating.MEDIUM);
    public static Prison prison = new Prison("Prison", lowSecurityUnit, mediumSecurityUnit, highSecurityUnit, yard, kitchen);



    public static void main(String[] args) throws IOException {
        // Adding inmateLoadList to appropriate SecurityUnit based upon securityRating
        InmateLoader inLoader = new InmateLoader("resources/data/inmate-data.csv");
        List<Inmate> inmateLoadList = inLoader.load();
        for (int i = 0; i < inmateLoadList.size(); i++) {
            switch (inmateLoadList.get(i).getSecurityRating()) {
                case LOW:
                    lowSecurityUnit.addInmate(inmateLoadList.get(i));
                    break;
                case MEDIUM:
                    mediumSecurityUnit.addInmate(inmateLoadList.get(i));
                    break;
                case HIGH:
                    highSecurityUnit.addInmate(inmateLoadList.get(i));
                    break;
            }
        }

        // launch GUI
        MainGui mainGui = new MainGui();

        // Update inmate counts in each area by passing Maps in this order
        //      [lowSecurityUnit, mediumSecurityUnit, highSecurityUnit, yard, kitchen]
        mainGui.updateCounts(lowSecurityUnit.getInmateMap(),
                mediumSecurityUnit.getInmateMap(),
                highSecurityUnit.getInmateMap(),
                yard.getInmateMap(),
                kitchen.getInmateMap());
    }
}