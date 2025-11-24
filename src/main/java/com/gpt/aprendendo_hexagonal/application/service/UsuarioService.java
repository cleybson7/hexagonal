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
        Usuario usuario = new Usuario(nome, email, senha);
        return repository.salvar(usuario);
    }

    @Override
    public Usuario atualizar(Long id, String nome, String email, String senha) {
        Usuario usuario = new Usuario(nome, email, senha);
        return repository.atualizar(id, usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.buscarTodos();
    }

    @Override
    public void deletar(Long id) {
        repository.deletarPorId(id);
    }
}
