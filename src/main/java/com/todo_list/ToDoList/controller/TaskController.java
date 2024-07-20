package com.todo_list.ToDoList.controller;

import com.todo_list.ToDoList.dto.ResponseEntity;
import com.todo_list.ToDoList.dto.TaskUpdateDto;
import com.todo_list.ToDoList.model.Task;
import com.todo_list.ToDoList.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createTask")
    private Task createTask(@RequestBody TaskUpdateDto task) {
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    private ResponseEntity<Task> getAllTasks() {
        List<Task> tasks= taskService.getTasks();
        if(!tasks.isEmpty()) {
            return new ResponseEntity<Task>("Success", tasks);
        } else {
            return new ResponseEntity<Task>("NO Tasks Available",tasks);
        }

    }

    @GetMapping("/tasks/{id}")
    private ResponseEntity<Task> getTasksById(@PathVariable String id) {
        Task task = taskService.getTask(Integer.parseInt(id));
        if(task == null) {
            return new ResponseEntity<Task>("Task not found", task);
        } else {
            return new ResponseEntity<Task>("Success",task);
        }
    }

    @GetMapping("/update")
    private ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return new ResponseEntity<Task>("Task Updated", taskService.updateTask(task));
    }

    @GetMapping("/delete/{id}")
    private ResponseEntity<String> delete(@PathVariable String id) {
        return new ResponseEntity<String>(taskService.deleteTask(Integer.parseInt(id)));
    }
}
