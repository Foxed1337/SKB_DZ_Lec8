package ru.zenkov.SKB_DZ_Lec8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zenkov.SKB_DZ_Lec8.models.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
