package util;

import hello.model.persistence.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by Innokentiy on 24.09.2016.
 */
public class DataManager {
    @Autowired
    UserService userService;
    public void fillRandom(int amount){
        for (int i = 0; i < amount; i++) {
            userService.create(randomUser());
        }

    }
    public User randomUser(){
        User user = new User();
        user.setFirstName(randomFirstName());
        user.setLastName(randomLastName());
        user.setPhoneNumber();
        user.setVkAddress();
        return user;
    }
    public String randomFirstName(){
        String[] namesArray = {"Бенедикт","Карл","Витольд","Богдан","Герман","Георгий","Павел","Трофим","Модест","Юрий","Адам","Никита"};
        List<String> names = Arrays.asList(namesArray);
        String name = names.get((int) (Math.random() * names.size()));
        return name;
    }
    public String randomLastName(){
        String[] surnamesArray = {"Максимов","Игнатьев","Рыжков","Румянцев","Понасенков","Федоров","Михалков","Кутузов","Петров","Лужков"};
        List<String> surnames = Arrays.asList(surnamesArray);
        String surname = surnames.get((int) (Math.random() * surnames.size()));
        return surname;
    }
    public int randomNumber(){
        String number = "8";
        switch ((int) (Math.random() * 3)){
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
        }
        return number;
    }
}
