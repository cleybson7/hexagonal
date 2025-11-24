package com.gpt.aprendendo_hexagonal.adapter.in.web.dto;

public record UsuarioRequestDto(
        String nome,
        String email,
        String senha
) {
}
