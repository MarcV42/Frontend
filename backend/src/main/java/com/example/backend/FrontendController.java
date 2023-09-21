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

}
