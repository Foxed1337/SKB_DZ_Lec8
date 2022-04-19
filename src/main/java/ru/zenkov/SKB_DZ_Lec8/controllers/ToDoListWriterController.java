package ru.zenkov.SKB_DZ_Lec8.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.zenkov.SKB_DZ_Lec8.models.Events;
import ru.zenkov.SKB_DZ_Lec8.models.ToDo;
import ru.zenkov.SKB_DZ_Lec8.repositories.ToDoRepository;

import javax.transaction.Transactional;

@Controller
public class ToDoListWriterController {

    @Autowired
    private ToDoRepository toDoRepository;

    @PostMapping("/write-todo")
    public ResponseEntity<String> createToDo(@RequestBody JsonNode todo_json) {
        ToDo todo = new ToDo();
        todo.setName(todo_json.findValue("name").asText());

        JsonNode events_json = todo_json.findValue("events");
        for (var event : events_json) {
            var new_event = new Events();
            new_event.setEvent(event.asText());
            todo.getEvents().add(new_event);
        }

        writeToDoToDB(todo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    public void writeToDoToDB(ToDo todo) {
        toDoRepository.save(todo);
        toDoRepository.flush();
    }
}
