package com.gpt.aprendendo_hexagonal.application.port.in;

import com.gpt.aprendendo_hexagonal.application.domain.Usuario;

@FunctionalInterface
public interface UsuarioCriarUseCase {
    Usuario criar(String nome, String email, String senha);
}
