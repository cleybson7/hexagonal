package com.gpt.aprendendo_hexagonal.application.port.in;

@FunctionalInterface
public interface UsuarioDeletarUseCase {
    void deletar(Long id);
}
