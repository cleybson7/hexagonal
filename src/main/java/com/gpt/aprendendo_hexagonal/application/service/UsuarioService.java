package com.gpt.aprendendo_hexagonal.application.service;

import com.gpt.aprendendo_hexagonal.application.domain.Usuario;
import com.gpt.aprendendo_hexagonal.application.port.in.*;
import com.gpt.aprendendo_hexagonal.application.port.out.UsuarioRepositoryOut;

import java.util.List;

public class UsuarioService implements UsuarioCriarUseCase, UsuarioBuscarUseCase, UsuarioListarUseCase, UsuarioAtualizarUseCase, UsuarioDeletarUseCase {

    private final UsuarioRepositoryOut repository;

    public UsuarioService(UsuarioRepositoryOut repository) {
        this.repository = repository;
    }

    @Override
    public Usuario criar(String nome, String email, String senha) {
        return null;
    }

    @Override
    public Usuario atualizar(Long id, String nome, String email, String senha) {
        return null;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        return List.of();
    }

    @Override
    public void deletar(Long id) {

    }
}
