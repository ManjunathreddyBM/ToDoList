package com.todo_list.ToDoList.repository;

import com.todo_list.ToDoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findAllById(int id);
}
