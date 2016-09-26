package util;

import hello.model.persistence.Task;
import hello.model.persistence.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by Innokentiy on 24.09.2016.
 */
public class DataManager {

    public Task randomTask(){
        Task task = new Task();
        task.setName(randomTaskName());
        task.setCategory(randomTaskCategory());
        task.setDescription(randomTaskDescription());
        task.setIsRequest(randomTaskRequest());
        return task;
    }
    private String randomTaskName(){
        String taskName = "test task";
        return taskName;
    }
    private String randomTaskCategory(){
        String[] categories = {"Физика","Кулинария","Музыка","Программирование","Философия"};
        int pos = (int)(Math.random()*5); //0-4
        String category = categories[pos];
        return category;
    }
    private String randomTaskDescription(){
        String description="Sample task description.";
        return description;
    }
    private boolean randomTaskRequest(){
        boolean isRequest;
        int var = (int)(Math.random()*2);
        if (var==0){
            return false;
        }else{return true;}
    }
    public User randomUser(){
        User user = new User();
        user.setFirstName(randomFirstName());
        user.setLastName(randomLastName());
        user.setPhoneNumber(randomNumber());
        user.setVkAddress(randomAddress());
        return user;
    }

    private String randomFirstName(){
        String[] namesArray = {"Бенедикт","Карл","Витольд","Богдан","Герман","Георгий","Павел","Трофим","Модест","Юрий","Адам","Никита"};
        List<String> names = Arrays.asList(namesArray);
        String name = names.get((int) (Math.random() * names.size()));
        return name;
    }
    private String randomLastName(){
        String[] surnamesArray = {"Максимов","Игнатьев","Рыжков","Румянцев","Понасенков","Федоров","Михалков","Кутузов","Петров","Лужков"};
        List<String> surnames = Arrays.asList(surnamesArray);
        String surname = surnames.get((int) (Math.random() * surnames.size()));
        return surname;
    }
    private Integer randomNumber(){
        String number = "";
        switch ((int) (Math.random() * 3)){
            case 0:
                number=number+"912";
                break;
            case 1:
                number=number+"919";
                break;
            case 2:
                number=number+"981";
                break;
        }
        switch ((int) (Math.random() * 3)){
            case 0:
                number=number+"929";
                break;
            case 1:
                number=number+"391";
                break;
            case 2:
                number=number+"787";
                break;
        }
        /*for (int i = 0; i < 4; i++) {
            number= number+(int) (Math.random() * 10);
        }*/

        return Integer.parseInt(number);
    }
    private String randomAddress(){
        String address = "vk.com/";
        Integer i = (int)(Math.random()*100);
        address+= i.hashCode();
        return address;
    }
}
