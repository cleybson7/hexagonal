package com.gpt.aprendendo_hexagonal.application.port.out;

import com.gpt.aprendendo_hexagonal.application.domain.Usuario;

import java.util.List;

public interface UsuarioRepositoryOut {

    Usuario salvar(Usuario usuario);
    List<Usuario> buscarTodos();
    Usuario buscarPorId(Long id);
    Usuario atualizar(Long id, Usuario usuario);
    void deletarPorId(Long id);
}
