package com.todo.backend.todo.jpa;

import com.todo.backend.todo.bean.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Todo_Jpa_Repository extends JpaRepository<Todo,Long> {

    List<Todo> findByUsername(String username);
}
