package com.apptodolist.backend.service;

import com.apptodolist.backend.models.Task;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    private Map<Long, Task> taskMap = new HashMap<>();
    private Long currentId = 1L;

    public List<Task> findAll() {
        return new ArrayList<>(taskMap.values());
    }

    public Task save(Task task) {
        task.setId(currentId++);
        taskMap.put(task.getId(), task);
        return task;
    }

    public Optional<Task> update(Long id, Task taskData) {
        Task task = taskMap.get(id);
        if (task != null) {
            task.setTitle(taskData.getTitle());
            task.setDescription(taskData.getDescription());
            task.setDone(taskData.isDone());
            return Optional.of(task);
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        return taskMap.remove(id) != null;
    }
}



