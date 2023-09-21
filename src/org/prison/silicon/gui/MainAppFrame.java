//package org.prison.silicon.gui;
package org.prison.silicon.gui;

import org.prison.silicon.facility.Prison;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static org.prison.silicon.facility.Facility.*;
import static org.prison.silicon.facility.Facility.WORK_AREA;

public class MainAppFrame {
    private final Prison prison;
    JFrame mainFrame;
    SplashPanel introPagePanel;

    public MainAppFrame(Prison prison) throws IOException {
        this.prison = prison;
        mainFrame = new JFrame();
        mainFrame.setTitle("JailBreak");
        mainFrame.setLayout(new GridLayout(1, 2, 10, 10));
        mainFrame.setSize(1300, 800);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        runApp();
    }

    public void runApp() throws IOException {
        introPagePanel = new SplashPanel(prison, mainFrame);
        mainFrame.add(introPagePanel.getSplashPanel());
        mainFrame.validate();
        mainFrame.repaint();
    }
}