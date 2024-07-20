package com.todo_list.ToDoList.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseEntity <T> {
    private T data;
    private List<T> dataList;
    private String message;

    public ResponseEntity (String message, T data) {
        super();
        this.data = data;
        this.message = message;
    }

    public ResponseEntity (String message, List<T> data) {
        super();
        this.message = message;
        this.dataList = data;
    }

    public ResponseEntity (String message) {
        super();
        this.message = message;
    }
}
