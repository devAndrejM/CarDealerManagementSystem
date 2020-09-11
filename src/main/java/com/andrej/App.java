package com.andrej;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener{
    private JPanel panelContainer;
    private JPanel MainPanel;
    private JPanel ButtonPanel;
    private JPanel User;
    private JButton publishButton;
    private JButton resetButton;
    private JButton exitButton;
    private JPanel Admin;
    private JButton publishButtonAdmin;
    private JButton resetButtonAdmin;
    private JButton editButtonAdmin;
    private JButton exitButtonAdmin;
    private JButton FindButtonAdmin;
    JPanel CustomerDetailsPanel;
    private JLabel CustomerID;
    JTextField idTxt;
    private JLabel FName;
    JTextField fNameTxt;
    private JLabel LName;
    JTextField lNameTxt;
    private JLabel Town;
    JTextField townTxt;
    private JLabel Postcode;
    JTextField zipTxt;
    private JLabel Address;
    JTextField addressTxt;
    private JPanel AccessoriesPanel;
    private JCheckBox stereoCheckBox;
    private JCheckBox modifiedCheckBox;
    private JCheckBox customizedCheckBox;
    private JCheckBox electricWindowsCheckBox;
    private JCheckBox GPSCheckBox;
    private JCheckBox leatherCheckBox;
    JPanel CarDetails;
    private JComboBox comboBox1;
    private JLabel CarModel;
    JTextField modelTxt;
    private JLabel Price;
    JTextField priceTxt;
    private JLabel Mileage;
    JTextField mileageTxt;
    private JLabel Year;
    JTextField yearTxt;
    private JPanel Welcome;
    private JPanel LoginForm;
    private JButton loginButton;
    private JButton createNewAccountButton;
    private JTextField userTxt;
    private JPasswordField passTxt;
    private JLabel Username;
    private JLabel Password;
    private JButton exitButtonWelcome;
    private JLabel Greeting;



    public App() {
        exitButton.setActionCommand("Exit");
        exitButton.addActionListener(this);
        exitButtonAdmin.setActionCommand("Exit");
        exitButtonAdmin.addActionListener(this);
        exitButtonWelcome.setActionCommand("Exit");
        exitButtonWelcome.addActionListener(this);

        resetButton.setActionCommand("Reset");
        resetButton.addActionListener(this);
        resetButtonAdmin.setActionCommand("Reset");
        resetButtonAdmin.addActionListener(this);



        };
        


    public static void main(String[] args) {
        JFrame frame = new JFrame("Car System Management");

        frame.setContentPane(new App().panelContainer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reset")) {
            JFrame resetFrame = new JFrame("Reset");
            int response = JOptionPane.showConfirmDialog(resetFrame, "Confirm if you want to reset",
                    "Reset", JOptionPane.YES_NO_OPTION);
            JTextField clearText;

            if (response == JOptionPane.YES_OPTION) {

                for (Component c : CustomerDetailsPanel.getComponents()) {
                    if (c.getClass().toString().contains("javax.swing.JTextField")) {
                        clearText = (JTextField) c;
                        clearText.setText("");
                        idTxt.setText("");
                        fNameTxt.setText("");
                        lNameTxt.setText("");
                        townTxt.setText("");
                        zipTxt.setText("");
                        addressTxt.setText("");

                    }

                }
                for (Component c : CarDetails.getComponents()) {
                    if (c.getClass().toString().contains("javax.swing.JTextField")) {
                        clearText = (JTextField) c;
                        clearText.setText("");
                        modelTxt.setText("");
                        priceTxt.setText("");
                        mileageTxt.setText("");
                        yearTxt.setText("");
                    }
                }
            } else if (response == JOptionPane.NO_OPTION) {
                resetFrame.dispose();
            } else if (response == JOptionPane.CLOSED_OPTION) {
                resetFrame.dispose();
            }
        } else if (e.getActionCommand().equals("Exit")) {
            JFrame frame;
            frame = new JFrame("Exit");

            if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                System.exit(0);
            }
        }
    }
    }

