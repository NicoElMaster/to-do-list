package com.apptodolist.backend.controllers;

import com.apptodolist.backend.models.*;
import com.apptodolist.backend.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:8081") // permite que el frontend se conecte
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // Se coloca el método GET
    @GetMapping
    public List<Task> getAll() {
        return service.findAll();
    }

    // Se coloca el método POST
    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.save(task);
    }

    // Se coloca el método PUT
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return service.update(id, task).orElseThrow();
    }

    // Se coloca el método DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}