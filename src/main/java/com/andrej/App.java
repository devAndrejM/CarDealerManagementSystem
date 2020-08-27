package com.andrej;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel CarSystemManagement;
    private JPanel CustomerDetails;
    private JPanel Accessories;
    private JPanel CarDetails;
    private JCheckBox Stereo;
    private JCheckBox Leather;
    private JCheckBox GPS;
    private JCheckBox Standard;
    private JCheckBox Modified;
    private JLabel ID;
    private JLabel FirstName;
    private JLabel LastName;
    private JLabel Address;
    private JLabel PostCode;
    private JLabel Town;
    private JTextField IDtxt;
    private JTextField FNametxt;
    private JTextField LNametxt;
    private JTextField Addresstxt;
    private JTextField ZIPtxt;
    private JTextField Towntxt;
    private JComboBox SelectCar;
    private JTextField Yeartxt;
    private JTextField Pricetxt;
    private JLabel Year;
    private JLabel Price;
    private JButton Exit;
    private JButton Reset;
    private JButton Apply;
    private JButton Find;
    private JCheckBox ElectricWindows;
    private JLabel Mileage;
    private JTextField Mileagetxt;
    private JLabel CarDetailsLabel;
    private JLabel CustomerDetailsLabel;
    private JTextField CarModeltxt;
    private JLabel CarModel;

    private JFrame frame;

    public App() {
        final JFrame exitFrame = new JFrame("Exit");
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(exitFrame, "Confirm if you want to exit", "Car Dealer Management System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
                {
                    System.exit(0);
                }
            }
        });
        final JFrame resetFrame = new JFrame("Reset");
        Reset.addActionListener(new ActionListener() {
            JTextField clearText = null;
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(resetFrame, "Confirm if you want to reset", "Reset", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

                    for (Component c : CustomerDetails.getComponents()) {
                        if (c.getClass().toString().contains("javax.swing.JTextField")) {
                            clearText = (JTextField) c;
                            clearText.setText("");
                            IDtxt.setText("");
                            FNametxt.setText("");
                            LNametxt.setText("");
                            Addresstxt.setText("");
                            ZIPtxt.setText("");
                            Towntxt.setText("");
                        }

                    }
                    for (Component c : CarDetails.getComponents()) {
                        if (c.getClass().toString().contains("javax.swing.JTextField")) {
                            clearText = (JTextField) c;
                            clearText.setText("");
                            Yeartxt.setText("");
                            Pricetxt.setText("");
                            Mileagetxt.setText("");
                            CarModeltxt.setText("");
                        }

                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Dealer Management System");
        frame.setContentPane(new App().CarSystemManagement);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
