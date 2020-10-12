package com.todo.backend.todo.resource;

import com.todo.backend.todo.bean.Todo;
import com.todo.backend.todo.jpa.Todo_Jpa_Repository;
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
public class TodoJpaResources {


    @Autowired
    private Todo_Jpa_Repository todo_jpa_repository;

    //Find all todos
    @GetMapping(path = "jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable("username") String name) {
        return todo_jpa_repository.findByUsername(name);
        //return todoService.findAll();
    }

    //Find required todo by id
    @GetMapping(path = "jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable("username") String name, @PathVariable long id) {
        return todo_jpa_repository.findById(id).get();
        //return todoService.findById(id);
    }

    //Delete todo
    @DeleteMapping(path = "jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        todo_jpa_repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    //Add a  new Todo
    //POST users/{user_name}/todos
    @PostMapping(path = "jpa/users/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        Todo Createdtodo = todo_jpa_repository.save(todo);
        //Location
        //Get current resource url
        //{{id}}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(Createdtodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    //Update/Edit a Todo
    //PUT users/{user_name}/todos/{todo_id}
    @PutMapping(path = "jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                                           @PathVariable long id, @RequestBody Todo todo) {

        Todo Updatedtodo = todo_jpa_repository.save(todo);
        return new ResponseEntity<Todo>(Updatedtodo, HttpStatus.OK);
    }

}
