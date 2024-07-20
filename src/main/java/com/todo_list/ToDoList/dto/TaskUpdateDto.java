package com.todo_list.ToDoList.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class TaskUpdateDto {
    private String title;
    private String description;
    private String priority;
}
