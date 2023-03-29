package br.com.alura.adopet.domain.tutor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTutor(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String senha
) {
}