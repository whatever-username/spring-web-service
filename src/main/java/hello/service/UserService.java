package hello.service;

import hello.model.persistence.Task;
import hello.model.persistence.User;
import hello.repository.TaskRepository;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.DataManager;

import java.util.Collection;

/**
 * Created by техносила on 24.08.2016.
 */
@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void fillIn(int amount){
        DataManager manager = new DataManager();
        for (int i = 0; i < amount; i++) {
            create(manager.randomUser());
        }
    }
    public User findOne(Integer id){

        return userRepository.findOne(id);
    }

    public Collection<User> findAll() {
        Collection users = (Collection<User>)userRepository.findAll();
        return users;
    }
    public User create(User user){
        return userRepository.save(user);
    }
    public User update(User user){
        if (userRepository.exists(user.getId())==false){
            return null;
        }
        else {
            userRepository.delete(user.getId());
            userRepository.save(user);
            return user;
        }
    }
    public void delete(Integer id){
        userRepository.delete(id);
    }


}
