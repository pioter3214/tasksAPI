package org.example.apitask;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "description")
    private String desc;
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public Task() {
    }

    public Task(String desc, LocalDate dueDate, TaskStatus status, String title) {
        this.desc = desc;
        this.dueDate = dueDate;
        this.status = status;
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task{" +
                "desc='" + desc + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                '}';
    }
}
