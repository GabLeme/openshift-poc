package br.com.cxpbrasil.todoapi.web.request;

public record CreateTodoRequest(
        String title,
        String description
) {
}
