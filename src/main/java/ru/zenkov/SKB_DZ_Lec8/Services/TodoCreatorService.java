package ru.zenkov.SKB_DZ_Lec8.Services;

import org.springframework.stereotype.Service;
import ru.zenkov.SKB_DZ_Lec8.models.DeserializedTodo;
import ru.zenkov.SKB_DZ_Lec8.models.Events;
import ru.zenkov.SKB_DZ_Lec8.models.Todo;

@Service
public class TodoCreatorService {
    public Todo createTodo(DeserializedTodo desTodo) {
        var todo = new Todo();
        todo.setName(desTodo.getName());
        for (var event : desTodo.getEvents()) {
            var new_events = new Events();
            new_events.setEvent(event);
            todo.getEvents().add(new_events);
        }
        return todo;
    }
}
