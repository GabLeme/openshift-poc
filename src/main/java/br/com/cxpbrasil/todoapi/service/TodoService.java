package br.com.cxpbrasil.todoapi.service;

import br.com.cxpbrasil.todoapi.repository.TodoRepository;
import br.com.cxpbrasil.todoapi.repository.entity.TodoEntity;
import br.com.cxpbrasil.todoapi.web.request.CreateTodoRequest;
import br.com.cxpbrasil.todoapi.web.response.TodoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponse create(CreateTodoRequest request) {
        var result = todoRepository
                .save(TodoEntity.fromRequest(request));

        return result.toResponse();
    }

    public List<TodoResponse> findAll() {
        return todoRepository.findAll()
                .stream().map(TodoEntity::toResponse)
                .collect(Collectors.toList());
    }
}
