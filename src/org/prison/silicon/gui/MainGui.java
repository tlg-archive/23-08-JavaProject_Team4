//package org.prison.silicon.gui;
package org.prison.silicon.gui;

import org.prison.silicon.facility.Facility;
import org.prison.silicon.facility.Prison;

import org.prison.silicon.population.Inmate;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class MainGui {
    JFrame mainFrame;
    // LowSecurityUnitPanel lowSecurityUnitPanel;
    FacilityAreaPanel lowSecurityUnitPanel;
    // MediumSecurityUnitPanel mediumSecurityUnitPanel;
    FacilityAreaPanel mediumSecurityUnitPanel;
    // HighSecurityUnitPanel highSecurityUnitPanel;
    FacilityAreaPanel highSecurityUnitPanel;
    // YardPanel yardPanel;
    FacilityAreaPanel yardPanel;
    // KitchenPanel kitchenPanel;
    FacilityAreaPanel kitchenPanel;
    // WorkAreaPanel workAreaPanel;
    FacilityAreaPanel workAreaPanel;
    ScorePanel scorePanel;
    UserInputPanel userInputPanel;

    public MainGui(Prison prison, Facility lowSecurityUnit, Facility mediumSecurityUnit, Facility highSecurityUnit, Facility yard,
                   Facility kitchen, Facility workArea) throws IOException {

        // lowSecurityUnitPanel = new LowSecurityUnitPanel(lowSecurityUnit);
        lowSecurityUnitPanel = new FacilityAreaPanel(lowSecurityUnit, "Low Security Unit");
        mediumSecurityUnitPanel = new FacilityAreaPanel(mediumSecurityUnit, "Medium Security Panel");
        highSecurityUnitPanel = new FacilityAreaPanel(highSecurityUnit, "High Security Unit");
        yardPanel = new FacilityAreaPanel(yard, "Yard");
        kitchenPanel = new FacilityAreaPanel(kitchen, "Kitchen");
        workAreaPanel = new FacilityAreaPanel(workArea, "Work Area");
        scorePanel = new ScorePanel(prison, lowSecurityUnit, mediumSecurityUnit, highSecurityUnit, yard, kitchen, workArea);
        userInputPanel = new UserInputPanel(prison,scorePanel, lowSecurityUnitPanel, mediumSecurityUnitPanel, highSecurityUnitPanel, yardPanel, kitchenPanel, workAreaPanel);

        mainFrame = new JFrame();
        mainFrame.setTitle("JailBreak");
        mainFrame.add(lowSecurityUnitPanel.getFacilityUnitPanel());
        mainFrame.add(mediumSecurityUnitPanel.getFacilityUnitPanel());
        mainFrame.add(highSecurityUnitPanel.getFacilityUnitPanel());
        mainFrame.add(scorePanel.getScorePanel());
        mainFrame.add(yardPanel.getFacilityUnitPanel());
        mainFrame.add(kitchenPanel.getFacilityUnitPanel());
        mainFrame.add(workAreaPanel.getFacilityUnitPanel());
        mainFrame.add(userInputPanel.getUserInputPanel());

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new GridLayout(2, 2, 10, 10));
        mainFrame.setSize(1300, 800);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // Action method to repaint the GUI as needed
    public void repaintGui() {
        mainFrame.repaint();
    }

    // Update all Panel counts
    public void updateCounts(Map<Integer, Inmate> lowSecurityMap, Map<Integer, Inmate> mediumSecurityMap,
                             Map<Integer, Inmate> highSecurityMap, Map<Integer, Inmate> yardMap,
                             Map<Integer, Inmate> kitchenMap, Map<Integer, Inmate> workAreaMap) {

        lowSecurityUnitPanel.updateInmateList(lowSecurityMap);
        mediumSecurityUnitPanel.updateInmateList(mediumSecurityMap);
        highSecurityUnitPanel.updateInmateList(highSecurityMap);
        yardPanel.updateInmateList(yardMap);
        kitchenPanel.updateInmateList(kitchenMap);
        workAreaPanel.updateInmateList(workAreaMap);

        // repaint the frame after updating all areas
        mainFrame.repaint();
    }
}