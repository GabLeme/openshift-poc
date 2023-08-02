package br.com.cxpbrasil.todoapi.web.response;

public record TodoResponse(
        Long id,
        String title,
        String description
) {
}
