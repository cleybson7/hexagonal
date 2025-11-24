package com.gpt.aprendendo_hexagonal.adapter.out.mapper;

import com.gpt.aprendendo_hexagonal.adapter.out.jpa.UsuarioEntity;
import com.gpt.aprendendo_hexagonal.application.domain.Usuario;

public class UsuarioMapper {

    public static Usuario toDomain(UsuarioEntity entity){
        return new Usuario(
                entity.getNome(),
                entity.getEmail(),
                entity.getSenha()
        );
    }

    public static UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }
}
