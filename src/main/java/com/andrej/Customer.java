package com.andrej;

public class Customer {

    //Data Member

    private String CustomerID;
    private String FirstName;
    private String LastName;
    private String Address;
    private String Postcode;
    private String Town;

    //Accessor Function
    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        this.CustomerID = customerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        this.Postcode = postcode;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        this.Town = town;
    }
}
