package com.gpt.aprendendo_hexagonal.adapter.out.jpa;

import com.gpt.aprendendo_hexagonal.adapter.out.mapper.UsuarioMapper;
import com.gpt.aprendendo_hexagonal.application.domain.Usuario;
import com.gpt.aprendendo_hexagonal.application.port.out.UsuarioRepositoryOut;

import java.util.List;

public class UsuarioRepositoryAdapter implements UsuarioRepositoryOut {

    private final UsuarioJpaRepository jpa;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity usuarioSalvo = jpa.save(entity);
        return UsuarioMapper.toDomain(usuarioSalvo);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return jpa.findAll().stream().map(UsuarioMapper::toDomain).toList();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return jpa.findById(id).map(UsuarioMapper::toDomain).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
    }

    @Override
    public Usuario atualizar(Long id, Usuario usuario) {
        UsuarioEntity usuarioAtualizado = jpa.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setEmail(usuario.getEmail());
        usuarioAtualizado.setSenha(usuario.getSenha());

        UsuarioEntity usuarioSalvo = jpa.save(usuarioAtualizado);
        return UsuarioMapper.toDomain(usuarioSalvo);
    }

    @Override
    public void deletarPorId(Long id) {
        jpa.deleteById(id);
    }
}
