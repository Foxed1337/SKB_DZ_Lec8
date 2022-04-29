package ru.zenkov.SKB_DZ_Lec8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zenkov.SKB_DZ_Lec8.models.Todo;
import ru.zenkov.SKB_DZ_Lec8.repositories.EventsRepository;
import ru.zenkov.SKB_DZ_Lec8.repositories.TodoRepository;

import java.util.List;

@RestController
public class TodoListGetterController {
    private TodoRepository toDoRepository;

    @GetMapping("/get-all-todo")
    public List<Todo> getAllToDo() {
        return toDoRepository.findAll();
    }

    @Autowired
    public void setToDoRepository(TodoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
}
