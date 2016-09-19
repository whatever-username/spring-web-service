package hello.model.persistence;

import java.util.Collection;
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String vkAddress;
    private Collection tasks;

    public User(){}
    public User(int id, String firstName, String lastName, int phoneNumber, String vkAdress){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.vkAddress = vkAdress;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getVkAddress() {
        return vkAddress;
    }
    public void setVkAddress(String vkAdress) {
        this.vkAddress = vkAdress;
    }
    public Collection getTasks() {
        return tasks;
    }
    public void setTasks(Collection tasks) {
        this.tasks = tasks;
    }

}
