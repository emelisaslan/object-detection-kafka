package com.Spring.Printer.Printer.Gui;

import javax.swing.*;
import java.awt.*;

public class Frontend extends JDialog {
    private JButton detectButton;
    private JPanel detectionPanel;
    private JTextArea textArea1;
    private JLabel carLabel;
    private JLabel humanLabel;
    private JLabel planeLabel;
    private JLabel humanHeader;
    private JLabel carHeader;
    private JLabel planeHeader;
    ImageIcon image = new ImageIcon("C:\\Users\\stj.emaslan\\Desktop\\PersonDetected\\personDetected.jpg");
    ImageIcon image1 = new ImageIcon("C:\\Users\\stj.emaslan\\Desktop\\PersonDetected\\personDetected.jpg");
    ImageIcon image2 = new ImageIcon("C:\\Users\\stj.emaslan\\Desktop\\PersonDetected\\personDetected.jpg");
    public Frontend(JFrame parent){
        super(parent);
        image.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        humanLabel.setIcon(image);
        carLabel.setIcon(image);
        planeLabel.setIcon(image);
        textArea1.setSize(70,10);
        setTitle("ObjectDetector");
        setContentPane(detectionPanel);
        setMinimumSize(new Dimension(600, 600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
