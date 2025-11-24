package com.gpt.aprendendo_hexagonal.adapter.out.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
}
