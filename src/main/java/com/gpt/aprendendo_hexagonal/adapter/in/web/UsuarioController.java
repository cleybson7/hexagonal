package com.gpt.aprendendo_hexagonal.adapter.in.web;

import com.gpt.aprendendo_hexagonal.adapter.in.web.dto.UsuarioRequestDto;
import com.gpt.aprendendo_hexagonal.adapter.in.web.dto.UsuarioResponseDto;
import com.gpt.aprendendo_hexagonal.application.domain.Usuario;
import com.gpt.aprendendo_hexagonal.application.port.in.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioCriarUseCase criarUseCase;
    private final UsuarioListarUseCase listarUseCase;
    private final UsuarioBuscarUseCase buscarUseCase;
    private final UsuarioAtualizarUseCase atualizarUseCase;
    private final UsuarioDeletarUseCase deletarUseCase;

    public UsuarioController(UsuarioCriarUseCase criarUseCase, UsuarioListarUseCase listarUseCase, UsuarioBuscarUseCase buscarUseCase, UsuarioAtualizarUseCase atualizarUseCase, UsuarioDeletarUseCase deletarUseCase) {
        this.criarUseCase = criarUseCase;
        this.listarUseCase = listarUseCase;
        this.buscarUseCase = buscarUseCase;
        this.atualizarUseCase = atualizarUseCase;
        this.deletarUseCase = deletarUseCase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> criar(@RequestBody UsuarioRequestDto dto) {
        Usuario usuario = criarUseCase.criar(dto.nome(), dto.email(), dto.senha());
        UsuarioResponseDto response = new UsuarioResponseDto(usuario.getNome(), usuario.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar(){
        List<Usuario> usuarioList = listarUseCase.listarTodos();
        List<UsuarioResponseDto> responseDtoList = usuarioList.stream()
                .map(r -> new UsuarioResponseDto(r.getNome(), r.getEmail())).toList();
        return ResponseEntity.status(HttpStatus.OK).body(responseDtoList);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioResponseDto> buscar(@PathVariable(value = "id") Long id){
        Usuario usuario = buscarUseCase.buscarPorId(id);
        UsuarioResponseDto response = new UsuarioResponseDto(usuario.getNome(), usuario.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioResponseDto> atualizar(@PathVariable(value = "id") Long id, @RequestBody UsuarioRequestDto requestDto){
        Usuario usuarioAtualizado = atualizarUseCase.atualizar(id, requestDto.nome(), requestDto.email(), requestDto.senha());
        UsuarioResponseDto responseDto = new UsuarioResponseDto(usuarioAtualizado.getNome(), usuarioAtualizado.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable(value = "id") Long id){
        deletarUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
