package ru.zenkov.SKB_DZ_Lec8.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeserializedTodo {
    private String name;
    private List<String> events;
}
