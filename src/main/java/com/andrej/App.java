package com.andrej;


import com.mysql.cj.protocol.FullReadInputStream;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

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
    private JButton deleteButton;


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

        publishButton.setActionCommand("Publish");
        publishButton.addActionListener(this);
        publishButtonAdmin.setActionCommand("Publish");
        publishButtonAdmin.addActionListener(this);

        FindButtonAdmin.setActionCommand("Find");
        FindButtonAdmin.addActionListener(this);

    };
        


    public static void main(String[] args)  {





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
        else if (e.getActionCommand().equals("Publish"))
        {
            JFrame publishFrame = new JFrame("Publish");
            int response = JOptionPane.showConfirmDialog(publishFrame, "Confirm if you want to publish",
                    "Publish", JOptionPane.YES_NO_OPTION);


            if (response == JOptionPane.YES_OPTION) {
                Connection myConn = null;
                PreparedStatement myStmt = null;



                try{
                    Properties props = new Properties();
                    props.load(new FileInputStream("sql.properties"));

                    String theUser = props.getProperty("user");
                    String thePassword = props.getProperty("password");
                    String theDburl = props.getProperty("dburl");

                    myConn = DriverManager.getConnection(theDburl, theUser, thePassword);
                    String sqlInsert = "INSERT INTO customer_info (FirstName,LastName,Town,ZIP,Address,Accessories,Maker,Model,Mileage,Year,Price) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    myStmt = myConn.prepareStatement(sqlInsert);
                    myStmt.setString(1, fNameTxt.getText());
                    myStmt.setString(2,lNameTxt.getText());
                    myStmt.setString(3, townTxt.getText());
                    myStmt.setInt(4, Integer.parseInt(zipTxt.getText()));
                    myStmt.setString(5,addressTxt.getText());

                    String sqlAccessories = "";
                    if(stereoCheckBox.isSelected())
                    {
                        String stereo = "Stereo,";
                        sqlAccessories += stereo;
                    }
                    if(customizedCheckBox.isSelected())
                    {
                        String customized = "Customized,";
                        sqlAccessories += customized;
                    }
                    if(leatherCheckBox.isSelected())
                    {
                        String leather = "Leather,";
                        sqlAccessories += leather;
                    }
                    if(modifiedCheckBox.isSelected())
                    {
                        String modified = "Modified,";
                        sqlAccessories += modified;
                    }
                    if(GPSCheckBox.isSelected())
                    {
                        String gps = "GPS,";
                        sqlAccessories += gps;
                    }
                    if(electricWindowsCheckBox.isSelected())
                    {
                        String windows = "Electric Windows,";
                        sqlAccessories += windows;
                    }

                    myStmt.setString(6,sqlAccessories);

                    myStmt.setString(7,(String) comboBox1.getSelectedItem());
                    myStmt.setString(8,modelTxt.getText());
                    myStmt.setInt(9,Integer.parseInt(mileageTxt.getText()));
                    myStmt.setInt(10,Integer.parseInt(yearTxt.getText()));
                    myStmt.setInt(11,Integer.parseInt(priceTxt.getText()));


                    myStmt.executeUpdate();


                    myConn.close();
                    myStmt.close();

                }
                catch(Exception exc){
                    exc.printStackTrace();
                }

                }
            else if (response == JOptionPane.NO_OPTION) {
                publishFrame.dispose();
            } else if (response == JOptionPane.CLOSED_OPTION) {
                publishFrame.dispose();
            }
        }
        else if (e.getActionCommand().equals("Find"))
        {

                Connection myConn = null;
                PreparedStatement myStmt = null;
                ResultSet myRs= null;


                try{
                    Properties props = new Properties();
                    props.load(new FileInputStream("sql.properties"));

                    String theUser = props.getProperty("user");
                    String thePassword = props.getProperty("password");
                    String theDburl = props.getProperty("dburl");

                    myConn = DriverManager.getConnection(theDburl, theUser, thePassword);
                    String sqlInsert = "SELECT FirstName,LastName,Town,Zip,Address,Accessories,Maker,Model,Mileage,Year,Price FROM customer_info WHERE CustomerID=?";
                    myStmt = myConn.prepareStatement(sqlInsert);
                    myStmt.setInt(1, Integer.parseInt(idTxt.getText()));
                    myRs = myStmt.executeQuery();
                    while(myRs.next()) {
                        fNameTxt.setText(myRs.getString("FirstName"));
                        lNameTxt.setText(myRs.getString("LastName"));
                        townTxt.setText(myRs.getString("Town"));
                        zipTxt.setText(myRs.getString("Zip"));
                        addressTxt.setText(myRs.getString("Address"));
                        mileageTxt.setText(myRs.getString("Mileage"));
                        yearTxt.setText(myRs.getString("Year"));
                        priceTxt.setText(myRs.getString("Price"));
                        comboBox1.setSelectedItem(myRs.getString("Maker"));
                        modelTxt.setText(myRs.getString("Model"));


                        if (myRs.getString("Accessories").contains("Stereo")){
                            stereoCheckBox.setSelected(true);
                        }
                        if (myRs.getString("Accessories").contains("Customized")) {
                            customizedCheckBox.setSelected(true);
                        }
                        if (myRs.getString("Accessories").contains("Leather")) {
                            leatherCheckBox.setSelected(true);
                        }
                        if (myRs.getString("Accessories").contains("Modified")) {
                            modifiedCheckBox.setSelected(true);
                        }
                        if (myRs.getString("Accessories").contains("GPS")) {
                            GPSCheckBox.setSelected(true);
                        }
                        if (myRs.getString("Accessories").contains("Electric Windows")) {
                            electricWindowsCheckBox.setSelected(true);
                        }
                    }





                    myConn.close();
                    myStmt.close();
                    myRs.close();

                }
                catch(Exception exc){
                    exc.printStackTrace();
                }

            }
        else if (e.getActionCommand().equals("Delete"))
        {
            
        }

        }
    }


