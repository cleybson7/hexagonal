package com.gpt.aprendendo_hexagonal.application.port.in;

import com.gpt.aprendendo_hexagonal.application.domain.Usuario;

@FunctionalInterface
public interface UsuarioAtualizarUseCase {
    Usuario atualizar(Long id, String nome, String email, String senha);
}
