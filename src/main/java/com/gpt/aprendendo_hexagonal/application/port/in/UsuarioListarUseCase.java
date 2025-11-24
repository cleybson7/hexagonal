package com.gpt.aprendendo_hexagonal.application.port.in;

import com.gpt.aprendendo_hexagonal.application.domain.Usuario;

import java.util.List;

@FunctionalInterface
public interface UsuarioListarUseCase {
    List<Usuario> listarTodos();
}
