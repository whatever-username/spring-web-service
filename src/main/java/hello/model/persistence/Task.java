package hello.model.persistence;

import javax.persistence.*;

/**
 * Created by техносила on 15.08.2016.
 */
public class Task {
    private int id;
    private String name;
    private String description;
    private String category;
    private int ownerId;
    private boolean isRequest;  //true = такую услугу ищут, false = такую услугу предлагают
    public Task(){}

    public Task(String name, String description, String category, int ownerId, boolean isRequest){
        this.name = name;
        this.description = description;
        this.category = category;
        this.ownerId = ownerId;
        this.isRequest = isRequest;
    }

    public String toString(){
        return ("name: "+name+", description: "+description+", category: "+category+", owner: "+ownerId);
    }
    public void setIsRequest(boolean request) {
        isRequest = request;
    }
    public boolean getIsRequest() {
        return isRequest;
    }
    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
