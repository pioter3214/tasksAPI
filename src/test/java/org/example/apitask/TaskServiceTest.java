package org.example.apitask;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void shouldReturnTasksWithProvidedState() {
        Task task1 = new Task(
                "Zrobić prezentację",
                LocalDate.of(2025, 10, 20),
                TaskStatus.TODO,
                "Prezentacja"
        );
        task1.setId(1L);

        Task task2 = new Task(
                "Przygotować raport",
                LocalDate.of(2025, 10, 22),
                TaskStatus.IN_PROGRESS,
                "Raport"
        );
        task2.setId(2L);

        Task task3 = new Task(
                "Napisać dokumentację",
                LocalDate.of(2025, 10, 25),
                TaskStatus.TODO,
                "Dokumentacja"
        );
        task3.setId(3L);

        Task task4 = new Task(
                "Przeprowadzić testy",
                LocalDate.of(2025, 10, 28),
                TaskStatus.IN_PROGRESS,
                "Testy"
        );
        task4.setId(4L);

        List<Task> all = Arrays.asList(task1,task2,task3,task4);

        doReturn(all).when(taskRepository).findAll();

        List<Task> tasks = taskService.getTasksByStatus(TaskStatus.TODO);

        for (Task task: tasks){
            assertEquals(TaskStatus.TODO,task.getStatus());
        }
    }
}