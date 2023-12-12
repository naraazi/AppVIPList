package android.alberto.applistavip.model;

public class User {
    private String firstname;
    private String surname;
    private String intendedCourse;
    private String phoneNumber;

    public User() {}

    public User(String firstName, String surname, String intendedCourse, String phoneNumber) {
        this.firstname = firstName;
        this.surname = surname;
        this.intendedCourse = intendedCourse;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIntendedCourse() {
        return intendedCourse;
    }

    public void setIntendedCourse(String intendedCourse) {
        this.intendedCourse = intendedCourse;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", intendedCourse='" + intendedCourse + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
