package org.example.apitask;

public class TaskWithSameIdExistsException extends RuntimeException {
    public TaskWithSameIdExistsException() {
        super("Task with that id already exists");
    }
}
