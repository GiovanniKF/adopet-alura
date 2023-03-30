package br.com.alura.adopet.dto;

import br.com.alura.adopet.model.Tutor;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTutor(
        Long id,
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String senha
) {

    public DadosCadastroTutor(Tutor tutor) {
        this(tutor.getId(), tutor.getNome(), tutor.getEmail(), tutor.getSenha());
    }
}