package br.com.cxpbrasil.todoapi.repository.entity;

import br.com.cxpbrasil.todoapi.web.request.CreateTodoRequest;
import br.com.cxpbrasil.todoapi.web.response.TodoResponse;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Table(name = "TB_TODO")
@Entity
@Builder
@EqualsAndHashCode
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TODO_ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    public TodoEntity() {
    }

    public TodoEntity(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static TodoEntity fromRequest(CreateTodoRequest request) {
        return TodoEntity.builder()
                .title(request.title())
                .description(request.description())
                .build();
    }

    public TodoResponse toResponse() {
        return new TodoResponse(
                getId(),
                getTitle(),
                getDescription()
        );
    }
}
