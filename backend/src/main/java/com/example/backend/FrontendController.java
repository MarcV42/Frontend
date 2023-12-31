package com.example.backend;

import com.example.backend.Entities.NewToDo;
import com.example.backend.Entities.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FrontendController {

    private final ToDoService toDoService;


    @GetMapping("/todo")
    public List<ToDo> getAllToDo(){
        return toDoService.getToDoList();
    }

    @PostMapping("/todo")
    public ToDo addToDo(@RequestBody NewToDo newToDo){
        return toDoService.addToDo(newToDo);
    }


    @GetMapping("/todo/{id}")
    public ToDo getToDoByID(@PathVariable String id){
        return toDoService.getToDoBy(id);
    }

    @PutMapping("/todo/{id}")
    public ToDo putToDoByID(@PathVariable String id, @RequestBody ToDo toDo) {
        return toDoService.updateToDo(id, toDo);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteToDoByID(@PathVariable String id) {
        toDoService.deleteToDo(id);
    }

}
