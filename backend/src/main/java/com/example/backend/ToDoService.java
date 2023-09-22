package com.example.backend;

import com.example.backend.Entities.NewToDo;
import com.example.backend.Entities.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public List<ToDo> getToDoList() {
        return toDoRepository.findAll();
    }

    public ToDo addToDo(NewToDo newToDo){
        ToDo toDo = new ToDo(UUID.randomUUID().toString(), newToDo.description(), newToDo.status());
        return  toDoRepository.save(toDo);
    }

    //Wenn er eine ID findet gibt er sie weiter ans frontend (Controller)
    // sonst ExceptionThrow
    public ToDo getToDoBy(String id) {
        return toDoRepository.findById(id).orElseThrow();
    }

    public ToDo updateToDo(String id, ToDo toDoToUpdate) {
        System.out.println("You just updated a ToDO");
        ToDo toDoToSave = new ToDo(id, toDoToUpdate.description(), toDoToUpdate.status());
        return toDoRepository.save(toDoToSave);
    }


    public void deleteToDo(String id) {
    }
}
