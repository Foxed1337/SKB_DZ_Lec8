package ru.zenkov.SKB_DZ_Lec8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.zenkov.SKB_DZ_Lec8.Services.TodoCreatorService;
import ru.zenkov.SKB_DZ_Lec8.models.DeserializedTodo;
import ru.zenkov.SKB_DZ_Lec8.models.Todo;
import ru.zenkov.SKB_DZ_Lec8.repositories.TodoRepository;

import javax.transaction.Transactional;

@Controller
public class TodoListWriterController {

    private TodoRepository toDoRepository;
    private TodoCreatorService todoCreator;

    @PostMapping("/write-todo")
    public ResponseEntity<String> createToDo(@RequestBody DeserializedTodo desTodo) {
        writeToDoToDB(todoCreator.createTodo(desTodo));
        return new ResponseEntity<>("Todo successfully added!",HttpStatus.OK);
    }

    @Transactional
    public void writeToDoToDB(Todo todo) {
        toDoRepository.save(todo);
    }

    @Autowired
    public void setToDoRepository(TodoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Autowired
    public void setTodoCreator(TodoCreatorService todoCreator) {
        this.todoCreator = todoCreator;
    }
}
