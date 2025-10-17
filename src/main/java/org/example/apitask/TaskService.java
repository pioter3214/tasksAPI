package org.example.apitask;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @PostConstruct
    public void init(){
        taskRepository.save(new Task(
                "Zrobić prezentację",
                LocalDate.of(2025, 10, 20),
                TaskStatus.TODO,
                "Prezentacja"
        ));

        taskRepository.save(new Task(
                "Przygotować raport",
                LocalDate.of(2025, 10, 22),
                TaskStatus.IN_PROGRESS,
                "Raport"
        ));

        taskRepository.save(new Task(
                "Wysłać maile do klientów",
                LocalDate.of(2025, 10, 18),
                TaskStatus.DONE,
                "Maile"
        ));
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        Optional<Task> task = taskRepository.findById(id);
        if(!task.isPresent()){
           throw new TaskNotFoundException(id);
        }
        return task.get();
    }

    public void addTask(Task task){
        if (task.getId() != null) {
            Optional<Task> optionalTask = taskRepository.findById(task.getId());
            if(optionalTask.isPresent()){
                throw new TaskWithSameIdExistsException();
            }
            task.setId(null);
        }
        taskRepository.save(task);
    }

    public Task updateTask(Long id,Task updatedTask){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()){
            throw new TaskNotFoundException(id);

        }
        if (updatedTask.getDesc() != null){
            optionalTask.get().setDesc(updatedTask.getDesc());
        }
        if (updatedTask.getStatus() != null){
            optionalTask.get().setStatus(updatedTask.getStatus());
        }
        if (updatedTask.getTitle() != null){
            optionalTask.get().setTitle(updatedTask.getTitle());
        }
        if (updatedTask.getDueDate() != null){
            optionalTask.get().setDueDate(updatedTask.getDueDate());
        }
        taskRepository.save(optionalTask.get());
        return optionalTask.get();
    }

    public void deleteTask(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()){
            throw new TaskNotFoundException(id);
        }
        taskRepository.delete(optionalTask.get());
    }

    public List<Task> getTasksByStatus(TaskStatus status){
//        return taskRepository.findAllByStatus(status)
//        zmiana pod testy
        return taskRepository.findAll().stream().filter(t -> t.getStatus() == status).toList();
    }

    public List<Task> getTasksByDueDate(LocalDate date){
        return taskRepository.findAllByDueDate(date);
    }
}
