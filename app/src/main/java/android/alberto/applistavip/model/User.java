package android.alberto.applistavip.model;

public class User {
    private String firstName;
    private String surname;
    private String intendedCourse;
    private String phoneNumber;

    public User(String firstName, String surname, String intendedCourse, String phoneNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.intendedCourse = intendedCourse;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", intendedCourse='" + intendedCourse + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
