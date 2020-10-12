package com.todo.backend.todo.resource;

import com.todo.backend.todo.bean.Todo;
import com.todo.backend.todo.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResources {

    @Autowired
    private TodoHardcodedService todoService;

    //Find all todos
    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable("username") String name) {
        return todoService.findAll();
    }

    //Find required todo by id
    @GetMapping(path = "/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable("username") String name,@PathVariable long id) {
        return todoService.findById(id);
    }

    //Delete todo
    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoService.deleteById(id);

        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Update/Edit a Todo
    //PUT users/{user_name}/todos/{todo_id}
    @PutMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable long id, @RequestBody Todo todo) {

        Todo Updatedtodo = todoService.save(todo);
        return new ResponseEntity<Todo>(Updatedtodo, HttpStatus.OK);
    }

    //Add a  new Todo
    //POST users/{user_name}/todos
    @PostMapping(path = "/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        Todo Createdtodo = todoService.save(todo);
        //Location
        //Get current resource url
        //{{id}}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(Createdtodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
