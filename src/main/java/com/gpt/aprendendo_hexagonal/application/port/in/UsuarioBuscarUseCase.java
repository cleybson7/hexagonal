package com.gpt.aprendendo_hexagonal.application.port.in;

import com.gpt.aprendendo_hexagonal.application.domain.Usuario;

@FunctionalInterface
public interface UsuarioBuscarUseCase {
    Usuario buscarPorId(Long id);
}
