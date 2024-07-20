package com.todo_list.ToDoList.service;

import com.todo_list.ToDoList.dto.TaskUpdateDto;
import com.todo_list.ToDoList.model.Task;
import com.todo_list.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskUpdateDto task) {
        Task newTask = new Task();
        newTask.setStatus("open");
        newTask.setPriority(task.getPriority());
        newTask.setDescription(task.getDescription());
        newTask.setTitle(task.getTitle());

        return taskRepository.save(newTask);
    }
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
    public Task getTask(int id) {
        return taskRepository.findAllById(id);
    }

    public Task updateTask(Task oldTask) {
        Task task = taskRepository.findAllById(oldTask.getId());
        task.setDescription(oldTask.getDescription());
        task.setTitle(oldTask.getTitle());
        task.setStatus(oldTask.getStatus());
        task.setPriority(oldTask.getPriority());
        return taskRepository.save(task);

    }

    public String deleteTask(int id) {
        Task task = taskRepository.findAllById(id);
        if(task == null) {
            return "No Task Available";
        } else {
            taskRepository.delete(task);
            return "Task " + id + " Deleted";
        }
    }


}
