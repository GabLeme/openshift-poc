package br.com.cxpbrasil.todoapi.repository;

import br.com.cxpbrasil.todoapi.repository.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
