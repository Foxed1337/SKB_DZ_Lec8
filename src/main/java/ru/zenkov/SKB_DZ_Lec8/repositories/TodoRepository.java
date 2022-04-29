package ru.zenkov.SKB_DZ_Lec8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zenkov.SKB_DZ_Lec8.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
