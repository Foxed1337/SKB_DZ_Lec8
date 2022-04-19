package ru.zenkov.SKB_DZ_Lec8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zenkov.SKB_DZ_Lec8.models.ToDo;
import ru.zenkov.SKB_DZ_Lec8.repositories.EventsRepository;
import ru.zenkov.SKB_DZ_Lec8.repositories.ToDoRepository;

import java.util.List;

@RestController
public class ToDoListGetterController {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private EventsRepository eventsRepository;

    @GetMapping("/get-all-todo")
    public List<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }
}
