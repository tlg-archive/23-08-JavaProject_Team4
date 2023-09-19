package org.prison.silicon.gui;

import org.prison.silicon.population.Inmate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WorkAreaPanel {
    private final JPanel workAreaPanel;
    private final JLabel title;
    private final Map<Integer, Inmate> currentInmates = new TreeMap<>();

    // Inmate image
    private final BufferedImage inmatePicture1 = ImageIO.read(new File("resources/images/prisoner.png"));
    private final Image inmate1 = inmatePicture1.getScaledInstance(25, 50, Image.SCALE_DEFAULT);


    public WorkAreaPanel() throws IOException {
        workAreaPanel = new JPanel();
        workAreaPanel.setLayout(null);
        title = new JLabel();
        title.setText("Work Area");
        title.setFont(title.getFont().deriveFont(Font.BOLD));
        title.setBounds(120, 5, 150, 25);
        workAreaPanel.add(title);
        workAreaPanel.setBorder(BorderFactory.createLineBorder(Color.black, 5, false));
        //mediumSecurityUnitPanel.setBounds(200, 10, 200, 200);
        workAreaPanel.setBackground(Color.lightGray);
    }

    private void paintInmates() {
        // Add inmate clipart based on the number of inmates in the LowSecurityUnit area.
        int xAxis = 25;
        int yAxis = 75;

        // TODO: count the number of inmates in the "LowSecurityUnit" Map
        //  then wrap the below line in a for-loop and increments the x and y axis as needed
        try{
            for(Map.Entry<Integer, Inmate> inmate : currentInmates.entrySet()) {
                // TODO: create JPanel for each inmate with NORTH = image & South = inmate ID
                workAreaPanel.add (new JLabel(new ImageIcon((inmate1)))).setBounds(xAxis, yAxis, 25, 50);
                if( xAxis <= 250){
                    xAxis += 50;
                } else {
                    xAxis = 25;
                    yAxis += 75;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public JPanel getWorkAreaPanel() {
        return workAreaPanel;
    }

    public void updateInmateList(Map<Integer, Inmate> inmates) {
        currentInmates.putAll(inmates);
        paintInmates();
    }
}