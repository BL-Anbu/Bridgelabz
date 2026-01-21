package Day_37_Practice_Problem.model;

import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public Person() {
    }

    public Person(String firstName, String lastName, String address,
                  String city, String state, String zip, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    // Getters & Setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // UC5 – Duplicate Check
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return firstName.equalsIgnoreCase(person.firstName) &&
                lastName.equalsIgnoreCase(person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }

    // UC6 – Print Output
    @Override
    public String toString() {
        return firstName + " " + lastName + " | " +
                city + ", " + state + " | " +
                zip + " | " + phoneNumber;
    }

}
