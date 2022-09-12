package com.Spring.Printer.Printer.Gui;

import com.Spring.Printer.Printer.PrinterApplication;
import com.Spring.Printer.Printer.StarterService.StarterService;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Frame extends JFrame implements ActionListener {
    Frame frame;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public static String path = "";


    public JButton healthButton = new JButton("System On");
    JButton selectionButton = new JButton("Select file");
    JTextArea imagePathArea;
    JButton detectionButton = new JButton("Detect Objects");

    JLabel infoLabel = new JLabel("");
    public JLabel planepicsLabel = new JLabel("", JLabel.CENTER);
    public JLabel carpicsLabel = new JLabel("", JLabel.CENTER);
    public JLabel humanpicsLabel = new JLabel("", JLabel.CENTER);
    final JLabel label = new JLabel();
    @SuppressWarnings("deprecation")
    public Frame() {
        //General Panel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1050, 850);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(45, 45, 45));
        contentPane.setForeground(new Color(176, 224, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //First box (purple)
        JPanel panel = new JPanel();
        panel.setBackground(new Color(230, 230, 250));
        panel.setBounds(90, 230, 250, 370);
        contentPane.add(panel);
        panel.setLayout(null);
        JLabel planeLabel = new JLabel("Detected Planes");
        planeLabel.setBounds(160, 200, 175, 13);
        planeLabel.setForeground(new Color(230,230,250));
        planeLabel.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
        contentPane.add(planeLabel);
        planepicsLabel.setBounds(10,10,230,350);
        setDefImage("C:\\Users\\stj.emaslan\\Desktop\\defaultpics\\radar.png", planepicsLabel);
        panel.add(planepicsLabel);
        //


        //Pink Panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(255, 228, 225));
        panel1.setBounds(380, 230, 250, 373);
        contentPane.add(panel1);
        panel1.setLayout(null);
        JLabel carLabel = new JLabel("Detected Cars");
        carLabel.setBounds(450, 200, 175, 13);
        carLabel.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
        carLabel.setForeground(new Color(255,225,225));
        contentPane.add(carLabel);
        carpicsLabel.setBounds(10,10,230,350);
        setDefImage("C:\\Users\\stj.emaslan\\Desktop\\defaultpics\\car.png", carpicsLabel);
        panel1.add(carpicsLabel);

        //Green Panel
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255,235,205));
        panel2.setBounds(670,230,250,373);
        panel2.setLayout(null);
        contentPane.add(panel2);
        humanpicsLabel.setBounds(10,10,230,350);
        JLabel humanLabel = new JLabel("Detected Humans");
        humanLabel.setBounds(740, 200, 175, 13);
        humanLabel.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
        humanLabel.setForeground(new Color(255,225,225));
        contentPane.add(humanLabel);
        setDefImage("C:\\Users\\stj.emaslan\\Desktop\\defaultpics\\body-scan.png", humanpicsLabel);
        panel2.add(humanpicsLabel);



        //Headingg/Info
        JLabel lblNewLabel = new JLabel("Welcome to my Object Detector! ");
        lblNewLabel.setFont(new Font("Montserrat Medium", Font.BOLD, 20));
        lblNewLabel.setBounds(350, 34, 350, 25);
        lblNewLabel.setForeground(new Color(153,153,255));
        contentPane.add(lblNewLabel);
        JLabel iconLabel = new JLabel();
        iconLabel.setBounds(650,25, 50,40);
        BufferedImage icon = null;
        try {
            icon = ImageIO.read(new File("C:\\Users\\stj.emaslan\\Desktop\\detect.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image image1 = icon.getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(image1);
        iconLabel.setIcon(imageIcon1);
        contentPane.add(iconLabel);


        JLabel lblNewLabel1 = new JLabel(
                "In this system, aeroplanes, cars and people on the image are detected. ");
        lblNewLabel1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel1.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
        lblNewLabel1.setForeground(new Color(139,136,139));
        lblNewLabel1.setBounds(328, 60, 778, 24);
        contentPane.add(lblNewLabel1);
        JLabel lblNewLabel4 = new JLabel(
                "After you press the detect button you can see the results in the boxes below.");
        lblNewLabel4.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 12));
        lblNewLabel4.setBounds(328, 80, 633, 13);
        lblNewLabel4.setForeground(new Color(139,136,139));
        contentPane.add(lblNewLabel4);
//

        JLabel lblNewLabel2 = new JLabel("Please select an image for object detection", JLabel.LEFT);
        lblNewLabel2.setBounds(240,110,300,50);
        lblNewLabel2.setForeground(new Color(190,190,190));
        lblNewLabel2.setFont(new Font("Montserrat Medium", Font.BOLD, 12));
        contentPane.add(lblNewLabel2);


        //Image Path Supplier
        /*imagePathArea= new javax.swing.JTextArea("Image path");
        imagePathArea.setBounds(210,110,450,40);
        imagePathArea.setLineWrap(true);
        imagePathArea.setWrapStyleWord(true);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
        imagePathArea.setBorder(border);
        sPanel.add(imagePathArea);
        imagePathArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                imagePathArea.setText("");
            }
            public void focusLost(FocusEvent e) {
                imagePathArea.setText("Description");
            }
        });*/
        selectionButton.setBounds(510, 110, 150, 50);
        selectionButton.setBorder(null);
        selectionButton.setBackground(new Color(153,204,255));
        contentPane.add(selectionButton);
        detectionButton.setBounds(680, 110, 150, 50);
        detectionButton.setBorder(null);
        detectionButton.setBackground(new Color(255,153,153));
        contentPane.add(detectionButton);
        contentPane.add(label);
        selectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int option = fileChooser.showOpenDialog(frame);
                if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    label.setText(""+file.getAbsolutePath());
                }else{
                    label.setText("Open command canceled");
                }
            }
        });
//





        healthButton.setFont(new Font("Montserrat Medium", Font.BOLD, 10));
        healthButton.setBounds(90, 680, 183, 55);
        healthButton.setBackground(new Color(153,255,153));
        healthButton.setBorder(null);
        contentPane.add(healthButton);

        //

        detectionButton.addActionListener(this);

    }

    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == detectionButton) {
            PrinterApplication.numOfHumans = 0;
            PrinterApplication.numOfPlanes = 0;
            PrinterApplication.numOfCars = 0;
            path = label.getText();
            System.out.println(path);
            if(path.equals("") ||path.equals(null) || (!path.substring(path.length()-3).equals("jpg") &&
                    !path.substring(path.length()-3).equals("png") && !path.substring(path.length()-4).equals("jpeg")) ||
                    !fileChecker(path)) {
                JOptionPane optionPane = new JOptionPane(
                        "Please give an appropriate path!.",
                        JOptionPane.WARNING_MESSAGE);
                JDialog dialog = optionPane.createDialog("Warning!");
                dialog.setVisible(true);
            }
/*
            if(PrinterApplication.numOfCars == 0){
                setDefImage("C:\\Users\\stj.emaslan\\Desktop\\defaultpics\\car.png", carpicsLabel);
            }
            if(PrinterApplication.numOfHumans == 0){
                setDefImage("C:\\Users\\stj.emaslan\\Desktop\\defaultpics\\body-scan.png", humanpicsLabel);
            }
            if(PrinterApplication.numOfPlanes == 0){
                setDefImage("C:\\Users\\stj.emaslan\\Desktop\\defaultpics\\radar.png", planepicsLabel);
            }
            else if(PrinterApplication.numOfCars != 0) {
                System.out.println(PrinterApplication.numOfCars);
                setImage("C:\\Users\\stj.emaslan\\Desktop\\CarsDetected\\detectedCars.jpg", carpicsLabel);
            }
            else if(PrinterApplication.numOfPlanes != 0) {
                System.out.println(PrinterApplication.numOfPlanes);
                setImage("C:\\Users\\stj.emaslan\\Desktop\\AeroplaneDetected\\aeroplaneDetected.jpg", planepicsLabel);
            }
            else if(PrinterApplication.numOfPlanes != 0) {
                System.out.println(PrinterApplication.numOfHumans);
                setImage("C:\\Users\\stj.emaslan\\Desktop\\PersonDetected\\personDetected.jpg", humanpicsLabel);
            }*/
            path = "";
            }
        }



    public boolean fileChecker (String path){
        File file = new File(path);
        if(file.exists() && !file.isDirectory()) {
            return true;
        }
        return false;
    }




    public void setImage (String imgPath, JLabel  label){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        label.setIcon(imageIcon);
    }

    public void setDefImage (String imgPath, JLabel  label){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(image);
        label.setIcon(imageIcon);
    }
}




