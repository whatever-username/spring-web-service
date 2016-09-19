package hello.service;

import hello.model.persistence.Task;
import hello.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.Collection;

/**
 * Created by техносила on 20.08.2016.
 */
@Service
public class TaskService{
    @Autowired
    private TaskRepository taskRepository;
    private Pageable pageable;
    private int totalPages;
    private int tasksPerPage=6;
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task findOne(Integer id){

        return taskRepository.findOne(id);
}

        public Collection<Task> findAll() {
            Collection tasks = (Collection<Task>)taskRepository.findAll();

            return tasks;
        }
    public Page<Task> findAllPaged(int page) {
        pageable = new PageRequest(0,tasksPerPage);
        Page<Task> tasks = taskRepository.findAll(pageable);
        totalPages = tasks.getTotalPages();
        return tasks;
    }
    public Page<Task> findNextPage(){
        Page<Task> nextPage;
        if (pageable.getPageNumber() <(totalPages-1)){
            nextPage = taskRepository.findAll(pageable.next());
            pageable = new PageRequest(nextPage.getNumber(),tasksPerPage);

        } else {
            nextPage= taskRepository.findAll(pageable.first());
            pageable = new PageRequest(0,tasksPerPage);
        }
        return nextPage;


    }
    public Page<Task> findPrevPage(){
        Page<Task> prevPage;
        prevPage = taskRepository.findAll(pageable.previousOrFirst());
        pageable = new PageRequest(prevPage.getNumber(),tasksPerPage);
        return prevPage;

    }



    public Task create(Task task){
        return taskRepository.save(task);
    }
    public Task update(Task task){
        if (taskRepository.exists(task.getId())==false){
            return null;
        }
        else {
            taskRepository.delete(task.getId());
            taskRepository.save(task);
            return task;
        }
    }
    public void delete(Integer id){
        taskRepository.delete(id);
    }
    public Collection<Task> findByType(String isRequest){
        boolean option = true;
        if (isRequest.equals("offers")){
            option = false;
        }
        Collection<Task> tasks = taskRepository.findByType(option);
        return tasks;
    }

}
