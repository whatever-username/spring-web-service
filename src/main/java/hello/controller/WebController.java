package hello.controller;

import hello.model.persistence.Task;
import hello.repository.TaskRepository;
import hello.service.TaskService;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by техносила on 31.08.2016.
 */
@Controller
public class WebController {
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    @RequestMapping("/tasks")
    public String tasks(Model model) {

        model.addAttribute("tasksList", taskService.findAllPaged(0));
        return "tasks";
    }
    @RequestMapping(value="/users/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable int id, Model model){
        model.addAttribute("userData", userService.findOne(id));
        return "user";
    }
    @RequestMapping("main/nextpage")
    public String getNextPage(Model model){
        model.addAttribute("tasksList",taskService.findNextPage());
        return "tasks :: tasksFragment";
    }
    @RequestMapping("main/prevpage")
    public String getPrevPage(Model model){
        model.addAttribute("tasksList",taskService.findPrevPage());
        return "tasks :: tasksFragment";
    }
}
